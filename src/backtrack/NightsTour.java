package backtrack;

public class NightsTour {
	
	private int boardSize;
	private int[][] solutionBoard;
	private int[] xMoves = {1, -1, 2, -2, -1, 1, -2, 2};
	private int[] yMoves = {2, 2, -1, -1, -2, -2, 1, 1};
	
	public NightsTour(int boardSize) {
		this.boardSize = boardSize;
		this.solutionBoard = new int[boardSize][boardSize];
	}
	
	public static void main(String[] args) {
		
		NightsTour tour = new NightsTour(8);
		tour.solve();
	}

	private void solve() {
		
		if ( solveNT(0,0, 1) ) {
			printSolution();
		} else {
			System.out.println("No solution !");
		}
	}


	private boolean solveNT(int row, int col, int stepCount) {
		
		if (stepCount == boardSize*boardSize) {
			solutionBoard[row][col] = stepCount;
			return true;
		}
		
		int nextX; 
		int nextY;
		
		for (int i = 0; i < 8; i++) {
			
			nextX = row + xMoves[i];
			nextY = col + yMoves[i];
			
			if (validMove(nextX, nextY, stepCount)) {
				solutionBoard[nextX][nextY] = stepCount;
				if (solveNT(nextX, nextY, stepCount+1)) {
					return true;
				} else {
					solutionBoard[nextX][nextY] = 0;
				}
			}
		}

		return false;
	}

	private boolean validMove(int row, int col, int stepCount) {
		
		if (row < 0 || row >= boardSize) {
			return false;
		}
		if (col < 0 || col >= boardSize) {
			return false;
		}
		if (solutionBoard[row][col] != 0) {
			return false;
		}
		
		return true;
	}

	private void printSolution() {
		for (int i = 0; i < solutionBoard.length; i++) {
			for (int j = 0; j < solutionBoard.length; j++) {
				System.out.print(solutionBoard[i][j] + " ");
			}
			System.out.println();
		}
	}

}
