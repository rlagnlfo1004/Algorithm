import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int k = stack.pop();
                answer[k] = i - k;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int k = stack.pop();
            answer[k] = prices.length - k - 1;
        }
        return answer;
    }
}