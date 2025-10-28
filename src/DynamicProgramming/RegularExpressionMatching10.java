package DynamicProgramming;

public class RegularExpressionMatching10 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        // dp[i][j] → true if first i chars of s match first j chars of p
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base case: empty string matches empty pattern
        dp[0][0] = true;

        // Handle patterns like a*, a*b*, a*b*c* that can match empty string
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // Case 1: Characters directly match or pattern has '.'
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // Case 2: Pattern has '*'
                else if (p.charAt(j - 1) == '*') {

                    // Case 2a: '*' represents zero occurrence of previous element
                    dp[i][j] = dp[i][j - 2];

                    // Case 2b: '*' represents one or more occurrences
                    // check if previous char in pattern matches current char in s
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        // Answer lies at dp[n][m] → full match of both strings
        return dp[n][m];
    }

    public static void main(String[] args) {

    }
}
