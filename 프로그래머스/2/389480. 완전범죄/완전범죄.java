import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        
        int[][] A = new int[info.length][m];
        for(int i = 0; i < info.length; i++)
            Arrays.fill(A[i], n);
        
        // 0번째 물건 선택
        if (info[0][0] < n) A[0][0] = info[0][0];              // A 선택
        if (info[0][1] < m) A[0][info[0][1]] = 0;              // B 선택
        
        for(int i = 0; i < info.length - 1; i++) {
            for(int j = 0; j < m; j++) {
                
                // A
                if(A[i][j] + info[i + 1][0] < n)
                    A[i + 1][j] = Math.min(A[i][j] + info[i + 1][0], A[i + 1][j]);
                
                // B
                if(j + info[i + 1][1] < m)
                    A[i + 1][j + info[i + 1][1]] = 
                            Math.min(A[i][j], A[i + 1][j + info[i + 1][1]]);
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++)
            answer = Math.min(A[info.length - 1][i], answer);
        return (answer < n) ? answer : -1;
    }
}