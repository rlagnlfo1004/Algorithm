class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] A = new int[24];
        for(int i = 0; i < 24; i++) {
            int temp = players[i] / m - A[i];
            if(temp > 0) {
                answer += temp;
                for(int j = 0; j < k; j++) {
                    if(i + j < 24) {
                        A[i + j] += temp;
                    }
                }
            }
        }
        return answer;
    }
}