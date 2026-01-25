/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10868                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10868                          #+#        #+#      #+#    */
/*   Solved: 2026/01/26 02:38:18 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int treeHight = 0;
        int num = N;
        while (num > 0) {
            num /= 2;
            treeHight++;
        }

        int treeSize = (int) Math.pow(2, treeHight + 1);
        int leafStart = treeSize / 2 - 1;
        tree = new int[treeSize];
        Arrays.fill(tree, Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++) {
            tree[leafStart + i] = Integer.parseInt(br.readLine());
        }

        // 초기화
        for (int i = treeSize - 1; i > 1; i -= 2) {
            tree[i / 2] = Math.min(tree[i], tree[i - 1]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            min(a + leafStart, b + leafStart);
        } 
    }

    static void min(int a, int b) {
        int minValue = Integer.MAX_VALUE;

        while(a <= b) {
            if(a % 2 == 1) minValue = Math.min(minValue, tree[a]);
            a = (a + 1) / 2;

            if(b % 2 == 0) minValue = Math.min(minValue, tree[b]);
            b = (b - 1) / 2;
        }

        System.out.println(minValue);
    }
}