package TwoPointers;

import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int distinctSubString(String s , int k) {

        HashMap<Character,Integer> map = new HashMap<>();

        int maxLen = 0;
        int start=0;
        for (int end=0; end<s.length(); end++) {
            char charEnd = s.charAt(end);
            map.put(charEnd , map.getOrDefault(charEnd,0)+1);

            if(map.size() > k) {
                char leftChar = s.charAt(start);
                map.put(leftChar , map.get(leftChar)-1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                start++;
            }
            maxLen = Math.max(maxLen , end-start+1);

        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "aaaabbbddddd";
        LongestSubstringWithAtMostKDistinctCharacters l = new LongestSubstringWithAtMostKDistinctCharacters();
        System.out.println(l.distinctSubString(s , 3));
    }
}



//O(2n);
//public int distinctSubString(String s , int k) {
//
//    HashMap<Character,Integer> map = new HashMap<>();
//
//    int maxLen = 0;
//    int start=0;
//    for (int end=0; end<s.length(); end++) {
//        char charEnd = s.charAt(end);
//        map.put(charEnd , map.getOrDefault(charEnd,0)+1);
//
//        while (map.size() > k) {
//            char leftChar = s.charAt(start);
//            map.put(leftChar , map.get(leftChar)-1);
//            if (map.get(leftChar) == 0) {
//                map.remove(leftChar);
//            }
//            start++;
//        }
//        maxLen = Math.max(maxLen , end-start+1);
//
//    }
//    return maxLen;
//}
