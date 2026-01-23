/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1068                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1068                           #+#        #+#      #+#    */
/*   Solved: 2026/01/23 15:05:35 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int result = 0;
    static int root;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(n == -1) {
                root = i;
                continue;
            }
            tree[i].add(n);
            tree[n].add(i);
        }

        M = Integer.parseInt(br.readLine());
        if(root == M) {
            System.out.println(0);
        } else {
            DFS(root);
            System.out.println(result);
        }

    }

    static void DFS(int v) {
        visited[v] = true;
        int count = 0;
        for (int i : tree[v]) {
            if(!visited[i] && i != M) {
                count++;
                DFS(i);
            }
        }

        if(count == 0) {
            result++;
        }
    }
}