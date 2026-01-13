/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1033                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1033                           #+#        #+#      #+#    */
/*   Solved: 2026/01/13 14:13:22 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {

    static long lcm = 1;
    static long D[];
    static ArrayList<Node>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A = new ArrayList[N];
        D = new long[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<Node>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            A[a].add(new Node(b, p, q));
            A[b].add(new Node(a, q, p));
            lcm *= p * q / gcd(p, q);
        }

        D[0] = lcm;
        dfs(0);
        long totalGcd = D[0];
        for (int i = 0; i < N; i++) {
            totalGcd = gcd(totalGcd, D[i]);
        }
        for (int i = 0; i < N; i++) {
            System.out.print(D[i] / totalGcd + " ");
        }
    }

    static long gcd(long a, long b) {
        if(b > a) {
            long temp = a;
            a = b;
            b = temp;
        }

        while (true) {
            long mod = a % b;
            if(mod == 0) {
                break;
            }
            a = b;
            b = mod;
        }
        return b;
    }

    static void dfs(int v) {
        visited[v] = true;
        for(Node node : A[v]) {
            int next = node.b;
            if(!visited[next]) {
                D[next] = D[v] * node.q / node.p;
                dfs(next);
            }
        }
    }

    static class Node {
        int b, p, q;
        public Node (int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }
    }
}