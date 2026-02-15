import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        
        ArrayList<Integer>[] A = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++)
            A[i] = new ArrayList<>();
        
        for(int i = 0; i < edge.length; i++) {
            A[edge[i][0]].add(edge[i][1]);
            A[edge[i][1]].add(edge[i][0]);
        }
        
        int[] distance = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        
        int max = 1;
        q.add(1);
        distance[1] = 1;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int next : A[now]) {
                if(distance[next] == 0) {
                    q.add(next);
                    distance[next] = distance[now] + 1;
                    if(distance[next] > max) {
                        max = distance[next];
                    }
                }
            }
        }
        
        int answer = 0;
        for(int temp : distance) {
            if(temp == max) {
                answer++;
            }
        }
        return answer;
    }
}