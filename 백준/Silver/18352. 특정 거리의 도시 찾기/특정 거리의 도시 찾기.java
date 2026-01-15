/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 18352                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/18352                          #+#        #+#      #+#    */
/*   Solved: 2026/01/15 15:37:59 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    static int[] visited;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;

        A = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        visited = new int[N];
        for (int i = 0; i < N; i++) {
            visited[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            A[a].add(b);
        }
        
        BFS(X);
        boolean exist = false;
        for (int i = 0; i < N; i++) {
            if(visited[i] == K) {
                System.out.println(i + 1);
                exist = true;
            }
        }
        if (!exist) System.out.println(-1);
    }

    static void BFS(int x) {
        Queue<Integer> q = new LinkedList<>();
        visited[x] = 0;
        q.add(x);

        while(!q.isEmpty()) {
            int v = q.poll();
            for (int node : A[v]) {
                if(visited[node] == -1) {
                    visited[node] = visited[v] + 1;
                    q.add(node);
                }
            }
        }
    }
}