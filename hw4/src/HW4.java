package hw4;
import java.util.Scanner;

public class HW4 {

    private static final double EPSILON = 1e-6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double[][] matrix = new double[n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
            matrix[i][n] = scanner.nextDouble();
        }

        scanner.close();

        int result = solve(matrix);

        switch (result) {
            case 1:
                System.out.println("The only solution");
                break;
            case 0:
                System.out.println("No solution");
                break;
            case -1:
                System.out.println("Infinite solutions");
                break;
        }
    }

    private static int solve(double[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] where = new int[m - 1];
        for (int i = 0; i < m - 1; i++) where[i] = -1;

        for (int col = 0, row = 0; col < m - 1 && row < n; ++col) {
            int sel = row;
            for (int i = row; i < n; ++i)
                if (Math.abs(matrix[i][col]) > Math.abs(matrix[sel][col]))
                    sel = i;
            if (Math.abs(matrix[sel][col]) < EPSILON)
                continue;
            for (int i = col; i < m; ++i) {
                double tmp = matrix[sel][i];
                matrix[sel][i] = matrix[row][i];
                matrix[row][i] = tmp;
            }
            where[col] = row;

            for (int i = 0; i < n; ++i)
                if (i != row) {
                    double c = matrix[i][col] / matrix[row][col];
                    for (int j = col; j < m; ++j)
                        matrix[i][j] -= matrix[row][j] * c;
                }
            ++row;
        }

        double[] ans = new double[m - 1];
        for (int i = 0; i < m - 1; ++i)
            if (where[i] != -1)
                ans[i] = matrix[where[i]][m - 1] / matrix[where[i]][i];
        for (int i = 0; i < n; ++i) {
            double sum = 0;
            for (int j = 0; j < m - 1; ++j)
                sum += ans[j] * matrix[i][j];
            if (Math.abs(sum - matrix[i][m - 1]) > EPSILON)
                return 0;
        }

        for (int i = 0; i < m - 1; ++i)
            if (where[i] == -1)
                return -1;
        return 1;
    }
}
