package Math;

public class AddDIgits_258 {
    public static int addDigits(int num) {
        if (num == 0) return num;
        return 1 + (num - 1) % 9;
    }
    public static void main(String[] args) {
        int n = 1001;
        System.out.println(AddDIgits_258.addDigits(n));

    }
}
