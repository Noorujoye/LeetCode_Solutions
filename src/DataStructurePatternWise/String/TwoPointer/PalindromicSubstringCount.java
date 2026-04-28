package DataStructurePatternWise.String.TwoPointer;

class PalindromicSubstringCount {

    /*
    =====================================================
    PROBLEM: Count Palindromic Substrings
    PATTERN: Expand Around Center (Two Pointer)

    -----------------------------------------------------
    KEY CONCEPTS:

    1️. Every palindrome has a center.
    2️. Center types:
        - Odd length  → (i, i)
        - Even length → (i, i+1)
    3️. Every successful expansion = 1 palindrome.
    4️. No substring creation required.
    5️. Total centers = 2n - 1 because for odd n , and even n-1

    -----------------------------------------------------
    TIME COMPLEXITY: O(n²)
    SPACE COMPLEXITY: O(1)
    =====================================================
    */

    public static int countSubstrings(String s) {

        int count = 0;

        // Loop through each index as potential center
        for (int i = 0; i < s.length(); i++) {

            // -------- ODD LENGTH PALINDROME --------
            int left = i;
            int right = i;

            while (left >= 0 &&
                    right < s.length() &&
                    s.charAt(left) == s.charAt(right)) {

                count++;        // Every expansion is a palindrome
                left--;
                right++;
            }

            // -------- EVEN LENGTH PALINDROME --------
            left = i;
            right = i + 1;

            while (left >= 0 &&
                    right < s.length() &&
                    s.charAt(left) == s.charAt(right)) {

                count++;
                left--;
                right++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "racecar";
        int cnt = PalindromicSubstringCount.countSubstrings(s);
        System.out.println("count is : " + cnt);
    }
}
