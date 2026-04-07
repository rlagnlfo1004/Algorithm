/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1753                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1753                           #+#        #+#      #+#    */
/*   Solved: 2026/04/08 02:24:01 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> A = new ArrayList<>();
        for(int i = 0; i <= V; i++) A.add(new ArrayList<>());
        
        int[] D = new int[V + 1];
        for(int i = 1; i <= V; i++) D[i] = Integer.MAX_VALUE;
        D[K] = 0;

        boolean[] visited = new boolean[V + 1];
        
        PriorityQueue<Node> Q = new PriorityQueue<>();
        Q.add(new Node(K, 0));

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            A.get(u).add(new Node(v, w));
        }

        while(!Q.isEmpty()) {
            Node now = Q.poll();
            if(visited[now.v]) continue;
            visited[now.v] = true;

            for(Node next : A.get(now.v)) {
                if(D[next.v] > D[now.v] + next.w) {
                    D[next.v] = D[now.v] + next.w;
                    Q.add(new Node(next.v, D[next.v]));
                }
            }
        }

        for(int i = 1; i <= V; i++) {
            if(visited[i]) bw.write(D[i] + "\n");
            else bw.write("INF\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}