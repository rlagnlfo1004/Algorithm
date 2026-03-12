/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 13023                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/13023                          #+#        #+#      #+#    */
/*   Solved: 2026/03/13 00:12:12 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static boolean result;
    static boolean[] visited;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        for(int i = 0; i < N; i++) {
            visited = new boolean[N];
            result = false;

            DFS(i, 1);
            if(result) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
        br.close();
    }

    static void DFS(int node, int depth) {
        if(depth == 5) {
            result = true;
            return;
        }

        visited[node] = true;
        for(int next : A[node]) {
            if(!visited[next]) {
                DFS(next, depth + 1);
                if(result) return;
            }
        }
        visited[node] = false;
    }
}