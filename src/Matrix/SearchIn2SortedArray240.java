package Matrix;

public class SearchIn2SortedArray240 {
        public static boolean matSearch(int mat[][], int x) {

            int n=mat.length;
            int m=mat[0].length;

            int i=0, j=m-1;

            while (i<n && j>=0) {

                if (x == mat[i][j]) return true;

                if (x > mat[i][j])  i++;  else j--;

            }
            return false;
        }

public static void main(String[] args) {
    int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
    int target = 7;
    System.out.println(matSearch(matrix,target));
     }
}
