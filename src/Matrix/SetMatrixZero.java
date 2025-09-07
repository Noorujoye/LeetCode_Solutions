package Matrix;

public class SetMatrixZero {

    // Method to set matrix zeroes
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        if (n == 0 || m == 0) {
            return;
        }

        int c = 1; // Flag to track if first column should be zeroed

        // Step 1: Mark rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    if (j == 0) {
                        c = 0;
                    } else {
                        mat[0][j] = 0;
                    }
                }
            }
        }

        // Step 2: Set zeroes using marks
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        // Step 3: Handle the first row
        if (mat[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }

        // Step 4: Handle the first column
        if (c == 0) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
    }

    // Method to print the matrix
    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        SetMatrixZero smz = new SetMatrixZero();

        int[][] mat = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        System.out.println("Original Matrix:");
        printMatrix(mat);

        smz.setMatrixZeroes(mat);

        System.out.println("\nMatrix after setMatrixZeroes:");
        printMatrix(mat);
    }
}
