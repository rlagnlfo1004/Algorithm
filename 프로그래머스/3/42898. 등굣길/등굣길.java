class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1_000_000_007;
        
        int[][] dp = new int[m + 1][n + 1];
        
        for(int[] puddle : puddles) {
            dp[puddle[0]][puddle[1]] = -1;
        }
        dp[1][1] = 1;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(dp[i][j] == -1) continue;
                
                if(i < m && dp[i + 1][j] != -1) {
                    dp[i + 1][j] = (dp[i + 1][j] + dp[i][j]) % MOD;
                }
                
                if(j < n && dp[i][j + 1] != -1) {
                    dp[i][j + 1] = (dp[i][j + 1] + dp[i][j]) % MOD;
                }
            }
        }
        return dp[m][n];
    }
}