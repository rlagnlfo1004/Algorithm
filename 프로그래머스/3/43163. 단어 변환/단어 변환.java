import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        ArrayList<Integer>[] A = new ArrayList[words.length + 1];
        for(int  i = 0; i < words.length + 1; i++) {
            A[i] = new ArrayList<>();
        }
        
        int end = 0;
        
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(target)) {
                end = i + 1;
            }
            
            if(translate(begin, words[i])) {
                A[0].add(i + 1);
                A[i + 1].add(0);
            }
        }
        
        if(end == 0) return 0;
        
        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++){
                if(translate(words[i], words[j])) {
                    A[i + 1].add(j + 1);
                    A[j + 1].add(i + 1);
                }
            }
        }
                   
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[words.length + 1];
        q.add(0);
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int next : A[now]) {
                if(next == end) {
                    return visited[now] + 1;
                }                 
                    
                if(visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    q.add(next);
                }
            }
        }
        return 0;
    }
    
    boolean translate(String a, String b) {
        boolean result = false;
        for(int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if(result) {
                    result = false;
                    break;
                }
                result = true;
            }
        }
        return result;
    }
}