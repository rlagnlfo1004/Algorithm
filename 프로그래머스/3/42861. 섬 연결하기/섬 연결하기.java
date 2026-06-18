import java.util.*;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        int answer = 0;
        int count = 0;
        
        for(int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];
            
            if(find(a) != find(b)) {
                union(a, b);
                answer += c;
                count++;
            }
            
            if(count == n - 1) break;
        }
        return answer;
    }
    
    private int find(int i) {
        if(parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    
    private void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        
        if(parentA != parentB) parent[parentB] = parentA;
    }
}