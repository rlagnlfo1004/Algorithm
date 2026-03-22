/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1753                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1753                           #+#        #+#      #+#    */
/*   Solved: 2026/03/22 19:47:52 by hrkim2001     ###          ###   ##.kr    */
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

        boolean[] visited = new boolean[V + 1];
        int[] distance = new int[V + 1];

        for(int i = 1; i <= V; i++) distance[i] = Integer.MAX_VALUE;
        distance[K] = 0;

        ArrayList<ArrayList<Edge>> A = new ArrayList<>();
        for(int i = 0; i <= V; i++) A.add(new ArrayList<>());
        
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            A.get(u).add(new Edge(v, w));
        }
        
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(K, 0));

        while(!q.isEmpty()) {
            Edge now = q.poll();
            if(visited[now.v]) continue;
            visited[now.v] = true;

            for(Edge next : A.get(now.v)) {
                if(distance[next.v] > distance[now.v] + next.w) {
                    distance[next.v] = distance[now.v] + next.w;
                    q.add(new Edge(next.v, distance[next.v]));
                }
            }
        }

        for(int i = 1; i <= V; i++) {
            if(distance[i] == Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(distance[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Edge implements Comparable<Edge> {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }
}