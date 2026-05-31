import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (a, b) -> b[0] - a[0]);
        int answer = 0;
        
        int m = targets[0][1];
        for(int[] t : targets) {
            int s = t[0];
            int e = t[1];
            
            if(e <= m) {
                m = s;
                answer++;
            }
        }
        return answer;
    }
}