/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1991                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1991                           #+#        #+#      #+#    */
/*   Solved: 2026/01/25 02:00:09 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    static int[][] tree;
    static int N;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new int[N][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'A';
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);
            tree[a][0] = b == '.' ? -1 : b - 'A';
            tree[a][1] = c == '.' ? -1 : c - 'A';
        }
        preOrder(0);
        bw.write("\n");
        inOrder(0);
        bw.write("\n");
        postOrder(0);
        bw.write("\n");

        bw.flush();
    }

    static void preOrder(int now) throws IOException {
        bw.write(now + 'A');

        if(tree[now][0] != -1) {
            preOrder(tree[now][0]);
        }
        
        if(tree[now][1] != -1) {
            preOrder(tree[now][1]);
        }
    }

    static void inOrder(int now) throws IOException {
        if(tree[now][0] != -1) {
            inOrder(tree[now][0]);
        }

        bw.write(now + 'A');
        
        if(tree[now][1] != -1) {
            inOrder(tree[now][1]);
        }
    }

    static void postOrder(int now) throws IOException {        
        if(tree[now][0] != -1) {
            postOrder(tree[now][0]);
        }
        
        if(tree[now][1] != -1) {
            postOrder(tree[now][1]);
        }

        bw.write(now + 'A');
    }
}