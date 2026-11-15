
class Solution {
    public int minCut(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        int[] cuts = new int[n];

        for (int i = 0; i < n; i++) {
            cuts[i] = i;

            for (int j = 0; j <= i; j++) {

                if (s.charAt(j) == s.charAt(i) &&
                    (i - j <= 2 || dp[j + 1][i - 1])) {

                    dp[j][i] = true;

                    if (j == 0) {
                        cuts[i] = 0;
                    } else {
                        cuts[i] = Math.min(
                            cuts[i],
                            cuts[j - 1] + 1
                        );
                    }
                }
            }
        }

        return cuts[n - 1];
    }
}