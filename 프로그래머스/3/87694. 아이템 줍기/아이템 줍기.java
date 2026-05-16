import java.util.*;

class Solution {
    int[][] map;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[102][102];
        
        for(int[] r: rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            
            for(int i = x1; i <= x2; i++) {
                for(int j = y1; j <= y2; j++) {
                    
                    if(i == x1 || i == x2 || j == y1 || j == y2) {
                        if(map[i][j] == 0) map[i][j] = 2;
                    } else {
                        map[i][j] = 1;
                    }
                }
            }
        }
        return BFS(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }
    
    int BFS(int x, int y, int s, int e) {
        int answer = 0;
        
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[102][102];
        
        deque.addLast(new int[] {x, y, 0});
        visited[x][y] = true;
        
        while(!deque.isEmpty()) {
            int[] now = deque.pollFirst();
            
            for(int k = 0; k < 4; k++) {
                int i = now[0] + dx[k];
                int j = now[1] + dy[k];
                int w = now[2];
                
                if(i == s && j == e) return w + 1;
            
                if(map[i][j] == 2 && !visited[i][j]) {
                    deque.add(new int[]{ i, j, w + 1 });
                    visited[i][j] = true;
                }
            }
        }
        return -1;
    }
}