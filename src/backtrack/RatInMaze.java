package backtrack;

public class RatInMaze {

	int[][] solutionBoard;
	int boardSize;

	public RatInMaze(int boardSize) {
		this.boardSize = boardSize;
		this.solutionBoard = new int[boardSize][boardSize];
	}

	public static void main(String[] args) {

		int maze[][] = { 
					{ 1, 1, 1, 1, 1 }, 
					{ 0, 0, 0, 0, 1 }, 
					{ 0, 1, 1, 0, 1 },
					{ 1, 0, 1, 1, 1 }, 
					{ 1, 0, 1, 1, 1 } 
				};

		RatInMaze problem = new RatInMaze(5);
		problem.solve(maze);
	}

	private void solve(int[][] maze) {

		if (solveMazeUtil(maze, 0, 0)) {
			printSolution();
		}else {
			System.out.println("No solution !");
		}
	}

	private boolean solveMazeUtil(int[][] maze, int x, int y) {

		if (x == boardSize - 1 && y == boardSize - 1) {
			solutionBoard[x][y] = 1;
			return true;
		}

		if (isSafe(x, y, maze)) {

			solutionBoard[x][y] = 1;

			if (solveMazeUtil(maze, x + 1, y)) {
				return true;
			}

			if (solveMazeUtil(maze, x, y + 1)) {
				return true;
			}

			solutionBoard[x][y] = 0;
		}

		return false;
	}

	private boolean isSafe(int x, int y, int[][] maze) {

		if (x >= boardSize || y > boardSize) {
			return false;
		}

		if (x < 0 || y < 0) {
			return false;
		}
		
		if (maze[x][y] == 0) {
			return false;
		}

		return true;
	}

	private void printSolution() {

		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				System.out.print(solutionBoard[i][j] + " ");
			}
			System.out.println();
		}
	}

}
