package SlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubString {
        private boolean contains(int[] s , int[] t) {
            for (int i=0; i<256; i++) {
                if (t[i] > s[i]) {
                    return false;
                }
            }
            return true;
        }
        public String minWindow(String s, String t) {

            if (t.length() > s.length()) return "";
            int[] sCount = new int[256];
            int[] tCount = new int[256];

            for (char a : t.toCharArray()) {
                tCount[a]++;
            }

            int left = 0, right = 0, start = 0, minLength = Integer.MAX_VALUE;

            for (; right < s.length(); right++) {

                sCount[s.charAt(right)]++;

                while (contains(sCount, tCount)) {
                    if (right - left + 1 < minLength) {
                        minLength = right - left + 1;
                        start = left;
                    }
                    sCount[s.charAt(left++)]--;
                }
            }
            return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
        }
    public static void main(String[] args) {
        String s = "ABCDEFG";
        String t = "CDE";
        MinimumWindowSubString m = new MinimumWindowSubString();
        System.out.println(m.minWindow(s , t));
    }
}
