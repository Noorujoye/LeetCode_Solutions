package Matrix;
import java.util.ArrayList;
public class SpiralMatrix {
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {

        int n = matrix[0].length;
        int m = matrix.length;

        if (n == 0 || m == 0 || matrix == null) return new ArrayList<>();

        ArrayList<Integer> res = new ArrayList<>();

        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {

            // for top row
            for (int i = left; i <= right; ++i) {
                res.add(matrix[top][i]);
            }
            top++;

            // last column
            for (int i = top; i <= bottom; ++i) {
                res.add(matrix[i][right]);
            }
            right--;


            if (top <= bottom) {
                // last row
                for (int i = right; i >= left; --i) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                // first column
                for (int i = bottom; i >= top; --i) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        ArrayList<Integer> res = spiralOrder(matrix);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }
}
