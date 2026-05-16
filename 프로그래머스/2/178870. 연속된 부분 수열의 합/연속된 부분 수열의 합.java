class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = sequence[0];
        int[] answer = new int[2];
        
        while(start <= end) {
            if(sum == k) {
                if(minLength > end - start) {
                    minLength = end - start;
                    answer[0] = start;
                    answer[1] = end;
                }
                
                if(end < sequence.length - 1) {
                    sum -= sequence[start++];
                    sum += sequence[++end];
                } else break;
            } else if(sum > k) {
                sum -= sequence[start++];
            } else {
                if(end < sequence.length - 1) {
                    sum += sequence[++end];
                } else break;
            }
        }
        
        return answer;
    }
}