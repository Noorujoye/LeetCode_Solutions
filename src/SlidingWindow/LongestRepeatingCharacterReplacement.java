package SlidingWindow;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int maxLen=0;
        int changes;
        int start=0;
        int maxF = 0;
        int[] hash = new int[26];

        for (int end=0; end<s.length(); end++) {

            hash[s.charAt(end) - 'A']++;

            maxF = Math.max(maxF , hash[s.charAt(end)-'A']);

            changes = (end-start+1) - maxF;

            if (changes > k) {
                hash[s.charAt(start) - 'A']--;
                start++;
            }

            maxLen = Math.max(maxLen , end-start+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "AAAABBBB";
        int k = 1;
        LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
        System.out.println(l.characterReplacement(s , k));
    }
}


// Brute force

/*
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int changes;
        int n = s.length();
        for (int i=0; i<n; i++) {
            int[] hash = new int[26];
            int maxF = 0;
            for (int j=i; j<n; j++) {
                hash[s.charAt(j) - 'A']++;
                maxF = Math.max(maxF , hash[s.charAt(j)-'A']);

                //in current window how many different character needs to be changed
                changes = (j-i+1) - maxF;

                if (changes <= k) {
                    maxLen = Math.max(maxLen , j-i+1);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }
 */