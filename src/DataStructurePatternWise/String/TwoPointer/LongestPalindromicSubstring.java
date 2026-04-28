package DataStructurePatternWise.String.TwoPointer;

/*
=========================================================
PROBLEM: Longest Palindromic Substring
PATTERN: Expand Around Center (Two Pointer)

---------------------------------------------------------
CORE IDEA:

1. Every palindrome has a CENTER.
2. Center can be:
      - Single character (odd length)
      - Between two characters (even length)
3. From every center, expand left and right
   while characters match.
4. Track maximum length and starting index.
5. Return substring at end.

---------------------------------------------------------
WHY i = 0 ?

Because every index is a possible center.
If string length = n
Possible centers = 2n - 1
(n odd centers + n-1 even centers)

---------------------------------------------------------
TIME COMPLEXITY:
O(n²)

SPACE COMPLEXITY:
O(1)

---------------------------------------------------------
IMPORTANT RULES:
✔ Boundary check first in while condition
✔ Never create substring inside loop
✔ Track start and maxLen only
✔ Extract substring once at end
=========================================================
*/

public class LongestPalindromicSubstring {

    public static String longestPalindromicSubstring(String s) {

        if (s == null || s.length() < 2)
            return s;

        int start = 0;   // starting index of longest palindrome
        int maxLen = 0;  // length of longest palindrome found

        // STEP 1: Loop over each index as potential center
        for (int i = 0; i < s.length(); i++) {

            // ----------- ODD LENGTH PALINDROME -----------
            int left = i;
            int right = i;

            while (left >= 0 &&
                    right < s.length() &&
                    s.charAt(left) == s.charAt(right)) {

                int currentLen = right - left + 1;

                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    start = left;
                }

                left--;
                right++;
            }

            // ----------- EVEN LENGTH PALINDROME -----------
            left = i;
            right = i + 1;

            while (left >= 0 &&
                    right < s.length() &&
                    s.charAt(left) == s.charAt(right)) {

                int currentLen = right - left + 1;

                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    start = left;
                }

                left--;
                right++;
            }
        }

        // STEP 2: Extract substring once
        return s.substring(start, start + maxLen);
    }

    //  MAIN METHOD
    public static void main(String[] args) {

        String s = "ABRBADAADAB";
        s = s.toLowerCase();

        String result = longestPalindromicSubstring(s);
        System.out.println("LPS: " + result);

        // --------- Proper Benchmark ---------
        String test = "a".repeat(5000);

        long startTime = System.nanoTime();

        for (int i = 0; i < 500; i++) {
            longestPalindromicSubstring(test);
        }

        long endTime = System.nanoTime();

        double timeInMs = (endTime - startTime) / 1_000_000.0;

        System.out.println("Execution time: " + timeInMs + " ms");
    }
}
