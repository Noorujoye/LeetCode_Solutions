package DataStructurePatternWise.String.TwoPointer;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            // skip non-alphanumeric chars
            if (!Character.isLetterOrDigit(l)) {
                left++;
                continue;
            }
            // skip non-alphanumeric chars
            if (!Character.isLetterOrDigit(r)) {
                right--;
                continue;
            }

            if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String name = "Noorain @ niraooN";
        boolean ans = ValidPalindrome.isPalindrome(name);
        System.out.println(ans);
    }
}
