import java.util.Arrays;

public class MazeSolver {

    static int N = 4; // Number of rows
    static int M = 4; // Number of columns

    // Function to print the solution path
    static void printSolution(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                System.out.print(sol[i][j] + " ");
            System.out.println();
        }
    }

    // Function to check if x,y is valid move
    static boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M && maze[x][y] == 1);
    }

    // Recursive function to solve the maze
    static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
        // If destination is reached
        if (x == N - 1 && y == M - 1) {
            sol[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y)) {
            sol[x][y] = 1; // Mark as part of solution path

            // Move right
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;

            // Move down
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;

            // Move left
            if (solveMazeUtil(maze, x, y - 1, sol))
                return true;

            // Move up
            if (solveMazeUtil(maze, x - 1, y, sol))
                return true;

            sol[x][y] = 0; // Backtrack
            return false;
        }

        return false;
    }

    // Function to solve the maze problem
    static boolean solveMaze(int[][] maze) {
        int[][] sol = new int[N][M];
        for (int[] row : sol)
            Arrays.fill(row, 0);

        if (!solveMazeUtil(maze, 0, 0, sol)) {
            System.out.println("No solution exists");
            return false;
        }

        System.out.println("Solution path (1 = path):");
        printSolution(sol);
        return true;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        solveMaze(maze);
    }
}
