/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1948                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1948                           #+#        #+#      #+#    */
/*   Solved: 2026/03/22 17:45:09 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Edge>> A = new ArrayList<>();
        ArrayList<ArrayList<Edge>> reverseA = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
            reverseA.add(new ArrayList<>());
        }

        int[] D = new int[N + 1];

        StringTokenizer st;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            A.get(u).add(new Edge(v, w));
            reverseA.get(v).add(new Edge(u, w));
            D[v]++;
        }
        
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        int[] length = new int[N + 1];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(S);

        while(!Q.isEmpty()) {
            int now = Q.poll();

            for(Edge next : A.get(now)) {
                length[next.v] = Math.max(length[next.v], length[now] + next.w);
                if(--D[next.v] == 0) Q.add(next.v);
            }
        }

        bw.write(length[E] + "\n");
        
        int result = 0;
        boolean[] visited = new boolean[N + 1];
        visited[E] = true;
        Q.add(E);

        while(!Q.isEmpty()) {
            int now = Q.poll();

            for(Edge next : reverseA.get(now)) {
                if(length[now] == length[next.v] + next.w) {
                    result++;

                    if(!visited[next.v]) {
                        visited[next.v] = true;
                        Q.add(next.v);
                    }
                }
            }
        }
        
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Edge {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}