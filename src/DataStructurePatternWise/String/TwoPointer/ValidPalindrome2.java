package DataStructurePatternWise.String.TwoPointer;

public class ValidPalindrome2 {
    private static boolean isPalindrome(String s , int left , int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }
    public static boolean validPalindrome2(String s) {
        int left = 0 , right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s , left+1, right) || isPalindrome(s , left , right-1);
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "NoorainniarooN";
        boolean ans = ValidPalindrome2.validPalindrome2(s);
        System.out.println(ans);
    }
}
