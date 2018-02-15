package VisaInterview;

public class FindCode {

	int x;
	int y;
	int N;

	public FindCode(int N) {
		this.N = N;
		this.x = 0;
		this.y = 0;
	}

	public static void main(String[] args) {

		FindCode findCode = new FindCode(9000);
		findCode.solve();

	}

	private void solve() {

		if (solveFindCode(0)) {
			printSolution();
		} else {
			System.out.println("No Solution !");
		}
	}

	private boolean solveFindCode(int y) {

		if ((N - 5 * y) < 0) {
			return false;
		}

		if (valid(y)) {
			this.x = (N - 5 * y) / 3;
			return true;
		} else {
			this.y = this.y + 1;
			if (solveFindCode(this.y)) {
				return true;
			}
		}

		return false;
	}

	private boolean valid(int y) {
		return ((N - 5 * y) % 3 == 0);
	}

	private void printSolution() {

		for (int i = 0; i < 3 * x; i++) {
			System.out.print(" 5 ");
		}

		for (int i = 0; i < 5 * y; i++) {
			System.out.print(" 3 ");
		}
	}

}
