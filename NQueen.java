import java.util.*;

public class NQueen {

    static int N;
    static int board[][];

    // Check safe position
    static boolean isSafe(int row, int col) {

        // Check row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }

        // Check upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check lower diagonal
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Backtracking function
    static boolean solve(int col) {

        // All queens placed
        if (col == N)
            return true;

        for (int row = 0; row < N; row++) {

            if (isSafe(row, col)) {

                board[row][col] = 1; // Place queen

                if (solve(col + 1))
                    return true;

                board[row][col] = 0; // Backtrack
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        N = sc.nextInt();

        board = new int[N][N];

        if (solve(0)) {

            System.out.println("Solution:");

            for (int i = 0; i < N; i++) {

                for (int j = 0; j < N; j++) {

                    if (board[i][j] == 1)
                        System.out.print("Q ");
                    else
                        System.out.print(". ");
                }

                System.out.println();
            }

        } else {
            System.out.println("No Solution Exists");
        }

        sc.close();
    }
}
