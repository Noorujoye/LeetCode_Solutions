package Bit_Manipulation;

public class PowerOfTwo {
    public static Boolean powerOfTwo(int n) {
        //    Base condition
//        if (n == 0) return false;
//        while (n % 2 == 0) {
//            n/=2;
//        }
//        return n == 1;

        //2nd approach best
        if (n==0) return false;
        long x = (long)n;
        return x == (x & -x); //& bitwise operator
    }
    public static void main(String[] args) {
        int n = 16;
        System.out.println(PowerOfTwo.powerOfTwo(n));
    }
}
