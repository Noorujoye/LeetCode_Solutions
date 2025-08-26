package Searching;

public class KthElementMergedSort {
    public static int kthElement(int a[], int b[], int k) {

        int n = a.length, m = b.length, i = 0, j = 0, last = 0;
        for (int d=0; d<k; d++) {

            if (i<n) {
                if (j<m && a[i] > b[j]) {
                    last = b[j];
                    j++;
                } else {
                    last = a[i];
                    i++;
                }

            }
            else if (j<m) {
                last = b[j];
                j++;
            }
        }
        return last;
    }
    public static void main(String[] args) {
        int a[] = {1,2,36,7,9};
        int b[] = {1,4,8,10};
        int k = 5;
        System.out.println(kthElement(a , b , k));
    }
}