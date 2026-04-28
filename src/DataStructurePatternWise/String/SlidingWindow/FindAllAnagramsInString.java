package DataStructurePatternWise.String.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {
    public static List<Integer> findAnagrams(String s , String p) {

        // create two maps of arr to store the frequency count of s and p
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        List<Integer> result = new ArrayList<>();

        // count the frequncy of p
        for (char a : p.toCharArray()) {
            pCount[a - 'a']++;
        }


        for (int i=0; i<s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            // remove character from front if window size increases
            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }
            if (Arrays.equals(sCount , pCount)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "hdhdhdhd";
        String p = "hd";
        List<Integer> list = FindAllAnagramsInString.findAnagrams(s , p);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
