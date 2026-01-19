/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1219                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1219                           #+#        #+#      #+#    */
/*   Solved: 2026/01/19 17:03:29 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    static Edge[] edges;
    static long[] distance;
    static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        distance = new long[N];
        for (int i = 0; i < N; i++) {
            distance[i] = Long.MIN_VALUE;
        }

        edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()),
                                Integer.parseInt(st.nextToken()),
                                Integer.parseInt(st.nextToken()));
        }

        money = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        distance[start] = money[start];
        for (int i = 0; i < 2 * N; i++) {
            for(Edge edge : edges) {
                if (distance[edge.s] == Long.MIN_VALUE) { 
                    continue;
                } else if (distance[edge.s] == Long.MAX_VALUE) {
                    distance[edge.e] = Long.MAX_VALUE;
                } else if (distance[edge.s] - edge.w + money[edge.e] > distance[edge.e]) {
                    distance[edge.e] = distance[edge.s] - edge.w + money[edge.e];
                    if (i >= N - 1) {
                        distance[edge.e] = Long.MAX_VALUE;
                    }
                }
            }
        }

        if(distance[end] == Long.MAX_VALUE) System.out.println("Gee");
        else if(distance[end] == Long.MIN_VALUE) System.out.println("gg");
        else System.out.println(distance[end]);
    }

    static class Edge {
        int s, e, w;
        public Edge (int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}