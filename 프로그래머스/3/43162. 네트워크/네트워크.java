import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            
            Queue<Integer> Q = new LinkedList<>();
            Q.add(i);
            visited[i] = true;
            answer++;
            
            while(!Q.isEmpty()) {
                int now = Q.poll();
            
                for(int j = 0; j < n; j++) {
                    if(computers[now][j] == 1 && j != now && !visited[j]) {
                        Q.add(j);
                        visited[j] = true;
                    }
                }
            }
        }
        
        return answer;
    }
}