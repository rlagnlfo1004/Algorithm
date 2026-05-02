import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return dfs(k, 0, visited, dungeons);
    }
    
    private int dfs(int hp, int count, boolean[] visited, int[][] dungeons) {
        int maxCount = count;
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && hp >= dungeons[i][0]) {
                visited[i] = true;
                int temp = dfs(hp - dungeons[i][1], count + 1, visited, dungeons);
                
                visited[i] = false;
                maxCount = Math.max(maxCount, temp);
            }
        }
        return maxCount;
    }
}