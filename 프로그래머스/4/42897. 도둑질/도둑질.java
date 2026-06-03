class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        return Math.max(
            steal(0, n - 2, money),
            steal(1, n - 1, money)
        );
    }
    
    private int steal(int start, int end, int[] money) {
        int prev1 = 0;
        int prev2 = 0;
        int curr = 0;
        
        for(int i = start; i <= end; i++) {
            curr = Math.max(prev1, prev2 + money[i]);
            
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}