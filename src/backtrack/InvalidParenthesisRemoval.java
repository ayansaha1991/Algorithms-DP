package backtrack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class InvalidParenthesisRemoval {

	private String expression;
	
	public InvalidParenthesisRemoval(String expression) {
		this.expression = expression;
	}

	private void solve() {
		
		Set<String> visited = new TreeSet<String>();
		Queue<String> queue = new LinkedList<String>();
		String temp ;
		
		queue.add(this.expression);
		visited.add(this.expression);
		
		while (!queue.isEmpty()) {
			
			String str = queue.poll();
			
			if (ifValidExpression(str)) {
				System.out.println("Valid : " + str );
				continue;
			}
			
			for (int i = 0; i < str.length(); i++) {
				
				if (!ifParenthessis(str.charAt(i))) {
					continue;
				}
				
				temp = str.substring(0, i) + str.substring(i+1);
				if (!visited.contains(temp)) {
					visited.add(temp);
					queue.add(temp);
				}
			}
		}
	}
	
	private boolean ifParenthessis(char el) {
		return (el == ')' || el == '(');
	}

	private boolean ifValidExpression(String expr) {

		int count = 0;
		
		if (expr == null || expr.equals(""))
			return false;
		
		for (int i = 0; i < expr.length(); i++) {

			if (expr.charAt(i) == '(') {
				count++;
			}

			if (expr.charAt(i) == ')') {
				count--;
			}
			
			if (count < 0)
				return false;
		}

		return (count == 0);
	}

	public static void main(String[] args) {
		
		InvalidParenthesisRemoval ipr = new InvalidParenthesisRemoval("()())()");
		ipr.solve();
	}

}
