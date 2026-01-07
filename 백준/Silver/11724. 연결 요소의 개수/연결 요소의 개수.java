/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11724                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11724                          #+#        #+#      #+#    */
/*   Solved: 2026/01/07 13:37:57 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] A = new ArrayList[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;

            A[n1].add(n2);
            A[n2].add(n1);
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                count++;
                DFS(A, visited, i);
            }
        }
        System.out.println(count);
    }

    static void DFS(ArrayList<Integer>[] A, boolean[] visited, int v) {
        if(visited[v]) {
            return;
        }
        visited[v] = true;
        for(int i : A[v]) {
            if(!visited[i]) DFS(A, visited, i);
        }
    }
}