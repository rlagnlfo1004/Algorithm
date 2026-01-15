/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1325                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1325                           #+#        #+#      #+#    */
/*   Solved: 2026/01/15 16:38:08 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int[] trust;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trust = new int[N + 1];
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            BFS(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, trust[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (max == trust[i]) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void BFS(int i) {
        visited = new boolean[N + 1];
        visited[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int node : A[x]) {
                if(!visited[node]) {
                    q.add(node);
                    trust[node]++;
                    visited[node] = true;
                }
            }
        }
    }
}