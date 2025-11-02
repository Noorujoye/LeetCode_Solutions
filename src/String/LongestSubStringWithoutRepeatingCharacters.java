package String;

import java.util.HashMap;
import java.util.HashSet;


public class LongestSubStringWithoutRepeatingCharacters {
    public int subString(String s) {
        HashMap<Character,Integer> lastSeen = new HashMap<>(); // lastSeen means at which index do this current char occur lastTime
        int maxlenOfSubString = 0;
        int start = 0;
        int end;
        for (end = 0; end < s.length(); end++) {

            char ch = s.charAt(end);

            // check whether this ch available in my map and if yes then at which index

            // i m checking to see current index of start
            if (lastSeen.containsKey(ch)) {
                start = Math.max(start , lastSeen.get(ch)+1);
            }

            lastSeen.put(ch , end);
            maxlenOfSubString = Math.max(maxlenOfSubString , end - start + 1);
        }
        this.startIdx = start;
        this.endIdx = end;
        return maxlenOfSubString;
    }
    private int startIdx = 0;
    private int endIdx = 0;
    public String actuaString(String s) {
        return s.substring(startIdx , endIdx);
    }
    public static void main(String[] args) {
        String[] str = {"abcdabcd" , "abc" ,  "acacb"};
        LongestSubStringWithoutRepeatingCharacters s = new LongestSubStringWithoutRepeatingCharacters();
        System.out.println(s.subString(str[0]) + ": " + s.actuaString(str[0]));
        System.out.println(s.subString(str[1]));
        System.out.println(s.subString(str[2]));
    }
}
