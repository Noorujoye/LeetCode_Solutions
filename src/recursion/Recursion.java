package recursion;

public class Recursion {
    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n-1);
    }
    public static String reverseString(String str) {
        StringBuilder s = new StringBuilder();

        for (int i=str.length()-1; i >=0; i--) {
            s.append(str.charAt(i));
        }
        if (s.equals(str)) {
            System.out.println("not reversed");
        } else System.out.println("reversed...");
        return s.toString();
    }
    // by recursion
    public static String reverseStringg(String s1) {
        if (s1.isEmpty()) return "";
        return reverseString(s1.substring(1)) + s1.charAt(0);
    }

    public static int sumOfNaturalN(int n) {
        if (n == 0) return 0;
        return n + sumOfNaturalN(n-1);
    }



    public static void main(String[] args) {
        System.out.println(Recursion.factorial(5));
        System.out.println(Recursion.reverseString("Noorain"));
        System.out.println(Recursion.reverseString("Noor"));
        String s = "Noor";
        System.out.println(Recursion.reverseStringg("Noorainnn"));
        System.out.println(Recursion.sumOfNaturalN(10));


    }
}
