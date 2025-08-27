package Searching;
import java.util.*;

class MagneticForceBtwTwoBalls {
    public static boolean check(int[] position, int m, int dist) {
        int cnt = 1;
        int prev = position[0];

        for (int i=1; i<position.length; i++) {
            if (position[i] - prev >= dist) {
                prev = position[i];
                cnt++;
            }
            if (cnt>=m) return true;
        }
        return false ;
    }
    public static int maxDistance(int[] position, int m) {

        Arrays.sort(position);
        int res = 0;

        int low = 1;
        int high = position[position.length-1] - position[0];

        while (low<=high) {

            int mid = low + (high-low)/2;

            if (check(position,m,mid)) {
                res = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int position[] = {1,2,3,4,7};
        int m = 3;
        int result = maxDistance(position,m);
        System.out.println(result);
    }
}