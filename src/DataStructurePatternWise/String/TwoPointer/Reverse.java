package DataStructurePatternWise.String.TwoPointer;

public class Reverse {
    public static void reverseString(String s) {
        char[] arr = s.toCharArray();
        int low = 0;
        int high = s.length()-1;
        while (low < high) {
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        System.out.println(arr);
    }
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    public static void main(String[] args) {
        String s = new String("Noorain");
        Reverse.reverseString(s);
        String reverse = Reverse.reverse("Warsi");
        System.out.println(reverse);
        String name = "Noorain";
        name = name.concat("world");
        System.out.println(name);
    }
}