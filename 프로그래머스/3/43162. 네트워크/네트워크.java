import java.util.*;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(computers[i][j] == 1) union(i, j);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(find(i));
        }
        return set.size();
    }
    
    int find(int i) {
        if(parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    
    void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        
        if(parentA != parentB) {
            parent[parentB] = parentA;
        }
    }
}