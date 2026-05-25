class Solution {
    final long MOD = 1234567;
    
    public long solution(int n) {
        
        long[][] dp = new long[n + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }
        
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        
        long answer = 0;
        for(int i = 0; i <= (n / 2); i++) {
            answer = (answer + dp[n - i][i]) % MOD;
        }
        return answer;
    }
}