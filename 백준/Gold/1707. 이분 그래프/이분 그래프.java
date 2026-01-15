/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1707                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1707                           #+#        #+#      #+#    */
/*   Solved: 2026/01/15 17:24:52 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {

    static int[] visited;
    static ArrayList<Integer>[] A;
    static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());

        for (int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A = new ArrayList[V + 1];
            visited = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                A[i] = new ArrayList();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                A[u].add(v);
                A[v].add(u);
            }
            
            result = true;
            for (int i = 1; i <= V; i++) {
                if(visited[i] == 0) {
                    BFS(i);
                }
                if (!result) {
                    break;
                }
            }
            if(result) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();

    }
    static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        visited[v] = 1;
        q.add(v);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i : A[node]) {
                if(visited[i] == 0) { // 방문 전
                    visited[i] = visited[node] * -1;
                    q.add(i);
                } else if (visited[i] == visited[node]) {
                    result = false;
                    return;
                }
            }
        }
    }
}