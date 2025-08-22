package Sorting;
import java.util.*;
public class Non_Overlapping_intervals {
    public static int RemoveOverlapInterval (int intervals[][]) {

        int count = 0;
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[1] , b[1]));
        int end = intervals[0][1];

        for (int i=0; i<intervals.length; i++) {
            //check for overlap
            if (intervals[i][0] < end) {
                count++;
                end = Math.min(intervals[i][1] , end);
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
    public static void main(String[] args) {

        int intervals[][] = {{1,2} , {2,3} , {3,4} , {1,3}};
        System.out.println(RemoveOverlapInterval(intervals));
    }
}
