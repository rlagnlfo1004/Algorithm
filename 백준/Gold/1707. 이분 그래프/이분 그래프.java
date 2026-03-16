/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1707                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1707                           #+#        #+#      #+#    */
/*   Solved: 2026/03/16 14:23:01 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {

    static int V;
    static int E;
    static ArrayList<Integer>[] A;
    static int[] visited;
    static boolean result = false; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            A = new ArrayList[V + 1];
            for(int i = 1; i <= V; i++) A[i] = new ArrayList<>();

            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                A[a].add(b);
                A[b].add(a);
            }

            visited = new int[V + 1];

            result = true;
            for(int i = 1; i <= V; i++) {
                if(visited[i] == 0) BFS(i);
                if(!result) break;
            }

            if(result) System.out.println("YES");
            else System.out.println("NO");
        }
        br.close();
    }

    static void BFS(int s) {
        visited[s] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int next : A[now]) {
                if(visited[next] == 0) {
                    visited[next] = visited[now] * -1;
                    q.add(next);
                } else if(visited[next] == visited[now]) {
                    result = false;
                }
            }
        }
    }
}