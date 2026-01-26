// /* ************************************************************************** */
// /*                                                                            */
// /*                                                      :::    :::    :::     */
// /*   Problem Number: 11437                             :+:    :+:      :+:    */
// /*                                                    +:+    +:+        +:+   */
// /*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
// /*                                                  +#+      +#+        +#+   */
// /*   https://boj.kr/11437                          #+#        #+#      #+#    */
// /*   Solved: 2026/01/27 02:41:41 by hrkim2001     ###          ###   ##.kr    */
// /*                                                                            */
// /* ************************************************************************** */
// import java.io.*;
// import java.util.*;

// public class Main {

//     static ArrayList<Integer>[] A;
//     static int[] parent;
//     static int[] depth;
//     static boolean[] visited;
    
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         int N = Integer.parseInt(br.readLine());
//         StringTokenizer st;

//         A = new ArrayList[N + 1];
//         parent = new int[N + 1];
//         depth = new int[N + 1];
//         visited = new boolean[N + 1];
//         for (int i = 1; i <= N; i++) {
//             A[i] = new ArrayList<>();
//         }

//         for (int i = 1; i < N; i++) {
//             st = new StringTokenizer(br.readLine());
//             int a = Integer.parseInt(st.nextToken());
//             int b = Integer.parseInt(st.nextToken());
//             A[a].add(b);
//             A[b].add(a);
//         }
        
//         DFS(1);
        
//         int M = Integer.parseInt(br.readLine());
//         for (int i = 0; i < M; i++) {
//             st = new StringTokenizer(br.readLine());
//             int a = Integer.parseInt(st.nextToken());
//             int b = Integer.parseInt(st.nextToken());
//             bw.write(LCA(a, b) + "\n");
//         }
//         bw.flush();
//     }

//     static void DFS(int v) {
//         visited[v] = true;
        
//         for(int i : A[v]) {
//             if(visited[i] == false) {
//                 visited[i] = true;
//                 parent[i] = v;
//                 depth[i] = depth[v] + 1;
//                 DFS(i);
//             }
//         }
//     }

//     static int LCA(int a, int b) {
//         if(depth[a] < depth[b]) {
//             int temp = a;
//             a = b;
//             b = temp;
//         }

//         while(depth[a] != depth[b]) {
//             a = parent[a];
//         }

//         while(a != b) {
//             a = parent[a];
//             b = parent[b];
//         }

//         return a;
//     }
// }

/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11437                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11437                          #+#        #+#      #+#    */
/*   Solved: 2026/01/27 02:41:41 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] A;
    static int[] parent;
    static boolean[] visited;
    static int[] depth;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        A = new ArrayList[N + 1];
        parent = new int[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }
        
        BFS(1);
        
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(LCA(a, b) + "\n");
        }
        bw.flush();
    }

    static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : A[now]) {
                if(visited[next] == false) {
                    visited[next] = true;
                    q.add(next);
                    parent[next] = now;
                    depth[next] = depth[now] + 1;
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

        while(depth[a] != depth[b]) {
            a = parent[a];
        }

        while(a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
}