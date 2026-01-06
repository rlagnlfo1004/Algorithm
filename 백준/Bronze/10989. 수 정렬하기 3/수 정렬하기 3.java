/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10989                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10989                          #+#        #+#      #+#    */
/*   Solved: 2026/01/06 15:22:56 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        sort(A);
        for (int i = 0; i < A.length; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void sort(int[] A) {
        int[] output = new int[A.length];
        int j = 1;

        for (int k = 0; k < 5; k++, j *= 10) { // 자리수 만큼
            int[] bucket = new int[10];
            for (int i = 0; i < A.length; i++) {
                bucket[A[i] / j % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i-1];
            }
            for (int i = A.length - 1; i >= 0; i--) {
                output[bucket[A[i] / j % 10] - 1] = A[i];
                bucket[A[i] / j % 10]--;
            }
            for (int i = 0; i < A.length; i++) {
                A[i] = output[i];
            }
        }
    }
}