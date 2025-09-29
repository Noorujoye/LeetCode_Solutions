package SlidingWindow;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

        public int lengthOfLongestSubstring(String s) {
            int maxLength = 0;
            int left = 0;
            Set <Character> set = new HashSet<>();
            for (int right = 0; right<s.length(); right++) {

                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength , right - left + 1);
            }
            return maxLength;
        }

        // ✅ Main method for testing
        public static void main(String[] args) {
            LongestSubstringWithoutRepeatingCharacters sol = new LongestSubstringWithoutRepeatingCharacters();

            String s1 = "abcabcbb";
            String s2 = "bbbbb";
            String s3 = "pwwkew";
            String s4 = "";

            System.out.println("Input: " + s1 + " → Longest length = " + sol.lengthOfLongestSubstring(s1));
            System.out.println("Input: " + s2 + " → Longest length = " + sol.lengthOfLongestSubstring(s2));
            System.out.println("Input: " + s3 + " → Longest length = " + sol.lengthOfLongestSubstring(s3));
            System.out.println("Input: " + s4 + " → Longest length = " + sol.lengthOfLongestSubstring(s4));
        }
    }

