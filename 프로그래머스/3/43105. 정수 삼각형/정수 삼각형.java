class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++) {
            dp[i][0] = triangle[i][0] + dp[i - 1][0];
            dp[i][i] = triangle[i][i] + dp[i - 1][i - 1];
            for(int k = 1; k < i; k++) {
                dp[i][k] = triangle[i][k] + Math.max(dp[i - 1][k - 1], dp[i - 1][k]);
            }
        }
        
        int answer = 0;
        for(int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, dp[triangle.length - 1][i]);
        }
        return answer;
    }
}