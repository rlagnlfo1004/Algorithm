class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] A = new boolean[n + 1][n + 1];
        
        for(int[] result : results) {
            A[result[0]][result[1]] = true;
        }
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(A[i][k] && A[k][j]) {
                        A[i][j] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            int count = 0;
            
            for(int j = 1; j <= n; j++) {
                if(i != j && (A[i][j] || A[j][i])) {
                    count++;
                }
            }
            if(count == n - 1) answer++;
        }
        return answer;
    }
}