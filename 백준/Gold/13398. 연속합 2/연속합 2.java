/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 13398                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/13398                          #+#        #+#      #+#    */
/*   Solved: 2026/02/01 18:03:51 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;
import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N];
        int[] L = new int[N];
        int[] R = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        L[0] = D[0];
        int result = L[0];
        for (int i = 1; i < N; i++) {
            L[i] = max(D[i], L[i - 1] + D[i]);
            result = max(result, L[i]);
        }

        R[N - 1] = D[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            R[i] = max(D[i], D[i] + R[i + 1]);
        }

        for (int i = 1; i < N - 1; i++) {
            result = max(result, L[i - 1] + R[i + 1]);
        }
        System.out.println(result);
    }
}