/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 13023                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/13023                          #+#        #+#      #+#    */
/*   Solved: 2026/01/07 14:35:17 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean answer = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            A[n1].add(n2);
            A[n2].add(n1);
        }
        br.close();

        for (int i = 0; i < N; i++) {
            DFS(i, 1);
            if(answer) {
                break;
            }
        }
        if(answer) System.out.println(1);
        else System.out.println(0);

    }

    static void DFS(int v, int depth) {
        if (answer) return;
        if (depth == 5) {
            answer = true;
            return;
        }

        visited[v] = true;
        for (int i : A[v]) {
            if (!visited[i]) {
                DFS(i, depth + 1);
            }
        }
        visited[v] = false;
    }
}