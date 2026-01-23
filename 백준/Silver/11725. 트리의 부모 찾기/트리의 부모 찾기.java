/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11725                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11725                          #+#        #+#      #+#    */
/*   Solved: 2026/01/23 14:44:24 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        A = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        visited = new int[N + 1];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        DFS(1);
        for (int i = 2; i <= N; i++) {
            bw.write(visited[i] + "\n");
        }
        bw.flush();
    }

    static void DFS(int v) {
        for (int i : A[v]) {
            if(visited[i] == 0) {
                visited[i] = v;
                DFS(i);
            }
        }
    }
}