class Solution {
    
    private int answer = Integer.MAX_VALUE;
    private int n;
    
    public int solution(int[][] cost, int[][] hint) {
        n = cost.length;
        int[] hintCount = new int[n];
        
        dfs(0, 0, hintCount, cost, hint);
        
        return answer;
    }
    
    private void dfs(int stage, int currentCost, int[] hintCount, int[][] cost, int[][] hint) {
        
        if(stage == n - 1) {
            int temp = 0;
            for(int i = 0; i < n; i++) {
                temp += cost[i][Math.min(hintCount[i], n - 1)];
            }
            
            if(answer > temp + currentCost) answer = temp + currentCost;
            return;
        }
        
        dfs(stage + 1, currentCost, hintCount, cost, hint);
        
        int price = hint[stage][0];
        for(int i = 1; i < hint[stage].length; i++) {
            int temp = hint[stage][i] - 1;
            hintCount[temp]++;
        }
        
        dfs(stage + 1, currentCost + price, hintCount, cost, hint);
        
        // 상태 복구
        for(int i = 1; i < hint[stage].length; i++) {
            int temp = hint[stage][i] - 1;
            hintCount[temp]--;
        }
    }
}