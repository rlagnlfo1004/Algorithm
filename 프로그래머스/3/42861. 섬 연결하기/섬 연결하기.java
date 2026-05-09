import java.util.*;

class Solution {
    
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        int answer = 0;
        
        for(int[] edge : costs) {
            if (union(edge[0], edge[1])) {
                answer += edge[2];                
            }
        }
        return answer;
    }
    
    public int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB) return false;

        parent[parentB] = parentA;
        return true;
    }
}