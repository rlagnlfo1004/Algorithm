import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];
                
                if(x >= 0 && y >= 0 && x < n && y < m && maps[x][y] == 1 && !visited[x][y]) {
                    if(x == n - 1 && y == m - 1)
                        return node.v + 1;
                    
                    visited[x][y] = true;
                    q.add(new Node(x, y, node.v + 1));
                }
            }
        }
        return -1;
    }
    
    class Node {
        int x, y, v;
        
        Node(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
}