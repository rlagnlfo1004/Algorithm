/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11438                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11438                          #+#        #+#      #+#    */
/*   Solved: 2026/01/28 03:41:45 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[][] parent;
    static boolean[] visited;
    static int[] depth;
    static int maxDepth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        visited = new boolean[N + 1];
        depth = new int[N + 1];

        maxDepth = 0;
        int temp = 1;
        while (temp < N) {
            temp <<= 1;
            maxDepth++;
        }
        
        parent = new int[maxDepth--][N + 1];
        BFS(1);
        
        for (int i = 1; i <= maxDepth; i++) {
            for (int j = 1; j <= N; j++) {
                parent[i][j] = parent[i - 1][parent[i-1][j]];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(LCA(a, b) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        parent[0][v] = 0;
        depth[v] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : tree[now]) {
                if(visited[next] == false) {
                    visited[next] = true;
                    parent[0][next] = now;
                    depth[next] = depth[now] + 1;
                    q.add(next);
                }
            }
        }
    }

    static int LCA(int a, int b) {
        if(depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = maxDepth; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = parent[i][a];
            }
        }

        if(a == b) {
            return a;
        }

        for (int i = maxDepth; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];
    }
}