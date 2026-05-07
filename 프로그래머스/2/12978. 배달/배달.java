import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        
        ArrayList<ArrayList<Node>> A = new ArrayList<>();
        for(int i = 0; i <= N; i++) A.add(new ArrayList<>());
        for(int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];
            
            A.get(a).add(new Node(b, c));
            A.get(b).add(new Node(a, c));
        }
        
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        
        PriorityQueue<Node> Q = new PriorityQueue<>();
        Q.add(new Node(1, 0));
        
        while(!Q.isEmpty()) {
            Node now = Q.poll();
            if(now.c > K) continue;
            
            for(Node next : A.get(now.b)) {
                if(distance[now.b] + next.c < distance[next.b]) {
                    distance[next.b] = distance[now.b] + next.c;
                    Q.add(new Node(next.b, distance[next.b]));
                }
            }            
        }
        
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            if(distance[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}

class Node implements Comparable<Node> {
    int b;
    int c;
    
    public Node(int b, int c) {
        this.b = b;
        this.c = c;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.c - o.c;
    }
}