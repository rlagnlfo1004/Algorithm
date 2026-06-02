class Solution {
    
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        
        int[][] diff = new int[n + 1][m + 1];
        
        for(int[] s : skill) {
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            
            if(s[0] == 1) degree *= -1;
            
            diff[r1][c1] += degree;
            diff[r1][c2 + 1] -= degree;
            diff[r2 + 1][c1] -= degree;
            diff[r2 + 1][c2 + 1] += degree;
        }
        
        for(int r = 0; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                diff[r][c] += diff[r][c - 1];
            }
        }
        
        for(int c = 0; c <= m; c++) {
            for(int r = 1; r <= n; r++) {
                diff[r][c] += diff[r - 1][c];
            }
        }
        
        int answer = 0;
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(diff[r][c] + board[r][c] > 0) answer++;
            }
        }
        return answer;
    }
}