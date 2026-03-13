/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1260                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1260                           #+#        #+#      #+#    */
/*   Solved: 2026/03/13 16:05:57 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        visited = new boolean[N + 1];
        DFS(V);

        bw.write("\n");

        visited = new boolean[N + 1];
        BFS(V);
        
        bw.flush();
        bw.close();
        br.close();
    }

    static void DFS(int n) throws IOException {
        visited[n] = true;
        bw.write(n + " ");

        for(int next : A[n]) {
            if(!visited[next]) DFS(next);
        }
    }

    static void BFS(int n) throws IOException {
        Queue<Integer> list = new LinkedList<>();
        list.add(n);
        visited[n] = true;

        while(!list.isEmpty()) {
            int now = list.poll();
            bw.write(now + " ");

            for(int next : A[now]) {
                if(!visited[next]) {
                    list.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}