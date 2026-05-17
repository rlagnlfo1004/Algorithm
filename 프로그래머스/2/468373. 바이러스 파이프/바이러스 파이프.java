import java.util.*;

class Solution {
    
    ArrayList<Integer>[][] A;
    int answer = 1;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        
        A = new ArrayList[4][n + 1];
        for(int i = 0; i <= 3; i++) {
            for(int j = 0; j <= n; j++) {
                A[i][j] = new ArrayList<>();   
            }
        }
        
        for(int[] edge : edges) {
            A[edge[2]][edge[0]].add(edge[1]);
            A[edge[2]][edge[1]].add(edge[0]);
        }
        
        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;
        
        dfs(0, 1, k, n, infected);
        
        return answer;
    }
    
    void dfs(int depth, int count, int k, int n, boolean[] infected) {
        if(depth == k) {
            answer = Math.max(answer, count);
            return;
        }
        
        for(int type = 1; type <= 3; type++) {
            boolean[] clone = infected.clone();
            int added = infect(type, n, clone);
            dfs(depth + 1, count + added, k, n, clone);
        }
    }
    
    int infect(int type, int n, boolean[] infected) {
        int count = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i = 1; i <= n; i++) {
            if(infected[i]) {
                deque.addLast(i);
            }
        }
        
        while(!deque.isEmpty()) {
            int now = deque.pollFirst();
            
            for(int next : A[type][now]) {
                if(!infected[next]) {
                    count++;
                    infected[next] = true;
                    deque.add(next);
                }
            }
        }
        return count;
    }
}