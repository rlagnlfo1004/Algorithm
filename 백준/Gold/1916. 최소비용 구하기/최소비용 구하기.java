/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1916                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1916                           #+#        #+#      #+#    */
/*   Solved: 2026/01/18 20:47:39 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Edge>> A = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            A.get(a).add(new Edge(b, c));
        }

        int[] distance = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        distance[start] = 0;
        
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(start, 0));

        while(!q.isEmpty()) {
            Edge nowEdge = q.poll();
            if(visited[nowEdge.v]) continue;
            visited[nowEdge.v] = true;

            for (Edge nextEdge : A.get(nowEdge.v)) {
                if(visited[nextEdge.v]) continue;
                if(distance[nextEdge.v] > distance[nowEdge.v] + nextEdge.d) {
                    distance[nextEdge.v] = distance[nowEdge.v] + nextEdge.d;
                    q.add(new Edge(nextEdge.v, distance[nextEdge.v]));
                }
            }
        }

        System.out.println(distance[end]);
    }

    static class Edge implements Comparable<Edge> {
        int v;
        int d;
        public Edge(int v, int d) {
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo (Edge e) {
            return this.d - e.d;
        }
    }
}