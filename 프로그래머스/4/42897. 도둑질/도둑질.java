class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        return Math.max(
            steal(money, 0, n - 2),
            steal(money, 1, n - 1)
        );
    }
    
    private int steal(int[] money, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;
        
        for(int i = start; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + money[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return Math.max(prev1, prev2);
    }
}