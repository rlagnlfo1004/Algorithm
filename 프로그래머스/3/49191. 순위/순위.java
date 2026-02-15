class Solution {
    public int solution(int n, int[][] results) {
        int[][] A = new int[n + 1][n + 1];
        for(int i = 0; i < results.length; i++) {
            A[results[i][0]][results[i][1]] = 1;
            A[results[i][1]][results[i][0]] = -1;
        }
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(A[i][k] == A[k][j] && A[i][k] != 0) {
                        A[i][j] = A[i][k];
                        A[j][i] = A[k][i];
                    }
                }
            }
        }
        
        
        int answer = 0;
        
        for(int i = 1; i <= n; i++) {
            boolean count = true;
            for(int j = 1; j <= n; j++) {
                if(i != j && A[i][j] == 0) {
                    count = false;
                }
            }
            
            if(count) answer++;
        }
        return answer;
    }
}