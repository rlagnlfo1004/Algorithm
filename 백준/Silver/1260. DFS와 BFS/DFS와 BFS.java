/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1260                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1260                           #+#        #+#      #+#    */
/*   Solved: 2026/01/07 15:45:04 by hrkim2001     ###          ###   ##.kr    */
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
        int V = Integer.parseInt(st.nextToken()) - 1;

        A = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            A[n1].add(n2);
            A[n2].add(n1);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(A[i]);
        }

        visited = new boolean[N];
        DFS(V);
        bw.write("\n");

        visited = new boolean[N];
        BFS(V);

        bw.flush();
        br.close();
        bw.close();
    }

    static void DFS(int v) throws IOException {
        bw.write(v+1 + " ");
        visited[v] = true;
        for (int i : A[v]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }

    static void BFS(int v) throws IOException {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        visited[v] = true;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            bw.write(now + 1 + " ");
            for (int i : A[now]) {
                if(!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}