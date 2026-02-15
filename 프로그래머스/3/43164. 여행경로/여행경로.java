import java.util.*;

class Solution {
    
    ArrayList<String> answer = new ArrayList<>();
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        DFS("ICN", "ICN", 0, tickets);
        
        Collections.sort(answer);
        return answer.get(0).split(" ");
    }
    
    void DFS(String start, String path, int depth, String[][] tickets) {
        if(depth == tickets.length) {
            answer.add(path);
            return;
        }
        
        
        for(int i = 0; i < tickets.length; i++) {
            if(start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                DFS(tickets[i][1], path + " " + tickets[i][1], depth + 1, tickets);
                visited[i] = false;
            }
        }
    }
}