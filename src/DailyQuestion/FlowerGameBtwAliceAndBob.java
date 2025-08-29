package DailyQuestion;
import java.util.*;
public class FlowerGameBtwAliceAndBob {
    public long flowerGame(int n, int m) {

        if (n==m) {
            long odd = (n+1)/2;
            long even = n/2;
            return 2*odd*even;
        }


        long aliceOdd = (n+1)/2;
        long aliceEven = n/2;

        long bobOdd = (m+1)/2;
        long bobEven = m/2;

        return aliceOdd*bobEven + aliceEven*bobOdd;

    }
    public static void main(String[] args) {

        FlowerGameBtwAliceAndBob pair = new FlowerGameBtwAliceAndBob();

        System.out.println(pair.flowerGame(3, 2)); // Output: 3
        System.out.println(pair.flowerGame(1, 1)); // Output: 0
    }
}
