/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2042                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2042                           #+#        #+#      #+#    */
/*   Solved: 2026/01/26 01:27:28 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static int treeHight;
    static int treeSize;
    static int indexStart;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        treeHight = 0;
        int num = N;
        while(num > 0) {
            num /= 2;
            treeHight++;
        }

        treeSize = (int) Math.pow(2, treeHight + 1);
        indexStart = treeSize / 2 - 1;

        tree = new long[treeSize];
        for (int i = 1; i <= N; i++) {
            tree[indexStart + i] = Long.parseLong(br.readLine());
        }
        initialize();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) swap(indexStart + b, c);
            else if(a == 2) sum(indexStart + b, indexStart + (int) c);
        }
    }

    static void initialize() {
        for (int i = treeSize - 1; i > 1; i--) {
            tree[i / 2] += tree[i];
        }
    }

    static void swap(int index, long num) {
        long diff = num - tree[index];

        while(index >= 1) {
            tree[index] += diff;
            index /= 2;
        }
    }

    static void sum(int start, int end) {
        long result = 0;

        while(start <= end) {
            if(start % 2 == 1) result += tree[start];
            start = (start + 1) / 2;

            if(end % 2 == 0) result += tree[end];
            end = (end - 1) / 2;
        }
        System.out.println(result);
    }
}