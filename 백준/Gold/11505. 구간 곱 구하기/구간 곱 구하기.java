/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11505                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11505                          #+#        #+#      #+#    */
/*   Solved: 2026/01/26 02:58:06 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static final int MOD = 1_000_000_007;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int treeHight = 0;
        int num = N;
        while(num > 0) {
            num /= 2;
            treeHight++;
        }

        int treeSize = (int) Math.pow(2, treeHight + 1);
        int leafStart = treeSize / 2 - 1;
        tree = new long[treeSize];
        Arrays.fill(tree, 1);

        for (int i = 1; i <= N; i++) {
            tree[leafStart + i] = Long.parseLong(br.readLine());
        }

        for (int i = treeSize - 1; i > 1; i--) {
            tree[i / 2] = tree[i] * tree[i / 2] % MOD;
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) swap(b + leafStart, c);
            else product(b + leafStart, (int)c + leafStart);
        }
    }

    static void swap(int index, long num) {
        tree[index] = num;
        while(index > 1) {
            index /= 2;
            tree[index] = tree[index * 2] % MOD * tree[index * 2 + 1] % MOD;
        }
    }

    static void product(int start, int end) {
        long result = 1;
        
        while(start <= end) {
            if(start % 2 == 1) result = result * tree[start] % MOD;
            start = (start + 1) / 2;

            if(end % 2 == 0) result = result * tree[end] % MOD;
            end = (end - 1) / 2;
        }

        System.out.println(result % MOD);
    }
}