package Matrix;

public class SearchTargetIn2dArray {
    public static Boolean searchMatrix(int matrix[][],int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0, high = (n*m-1);

        while (low <= high) {
            int mid = (low + high) / 2;

            int row = mid/m, col = mid % m;

            if (matrix[row][col] == target) return true;
            if (matrix[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
    public static void main(String[] args) {
            int[][] matrix = {{1, 5, 9},
                    {14, 20, 21},
                    {30, 34, 43}};
            int target = 14;

            if (searchMatrix(matrix, target))
                System.out.println("true");
            else
                System.out.println("false");
    }
}
