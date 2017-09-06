package backtrack;

public class NQueen {

	private int noOfQueens;
	private int board[][];
	
	public NQueen(int noOfQueen) {
		this.noOfQueens = noOfQueen;
		board = new int[noOfQueens][noOfQueens];
		
	}

	public void solve(int noOfQueens) {
		
		if (solveNQUtil(0)) {
			printSolutionBoard(board);
		}else {
			System.out.println("No Solution !!");
		}
	}


	private boolean solveNQUtil(int col) {
		
		if (col >= noOfQueens) {
			return true;
		}
		
		for (int row=0 ; row < noOfQueens ; row++) {
			
			if (isSafe(row, col)) {
				board[row][col] = 1;
				
				if (solveNQUtil(col+1))
					return true;
				
				board[row][col] = 0;
			}
		}
		
		return false;
	}

	private boolean isSafe(int row, int col) {
		int i, j;
		 
        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
 
        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)
                return false;
 
        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i<noOfQueens; i++, j--)
            if (board[i][j] == 1)
                return false;
 
        return true;
	}

	private void printSolutionBoard(int[][] board) {
		for (int i = 0; i < noOfQueens; i++) {
			for (int j = 0; j < noOfQueens; j++) {
				
				System.out.print(" " + board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		NQueen queen = new NQueen(10);
		queen.solve(queen.noOfQueens);
	}
}
