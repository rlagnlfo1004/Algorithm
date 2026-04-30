import java.util.*;

class Solution {
    
    private int[] parent;
    
    public int solution(int n, int[][] computers) {
    
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(computers[i][j] == 1 && i != j) union(i, j);
            }
        }
        
        int answer = 0;
        Set<Integer> net = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            if(net.add(find(i))) answer++;
        }
        return answer;
    }
    
    private void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        
        if(parentA != parentB) parent[parentB] = parentA;
    }
    
    private int find(int a) {
        if(parent[a] == a) return a;
        
        return parent[a] = find(parent[a]);
    }
}