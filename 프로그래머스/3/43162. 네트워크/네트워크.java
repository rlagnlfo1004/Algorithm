class Solution {
    int[] parent;
    
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(computers[i][j] == 1)
                    union(i, j);
            }
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            int A = find(i);
            
            if(visited[A] == false) {
                answer++;
                visited[A] = true;
            }
        }
        return answer;
    }
    
    void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        
        if(A != B) {
            parent[B] = A;
        }
    }
    
    int find(int n) {
        if(parent[n] == n)
            return parent[n];
        
        return parent[n] = find(parent[n]);
    }
}