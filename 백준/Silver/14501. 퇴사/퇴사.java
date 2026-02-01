/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14501                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14501                          #+#        #+#      #+#    */
/*   Solved: 2026/02/01 15:59:57 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] D = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken()) + i;
            if(T[i] <= N + 1) {
                P[i] = Integer.parseInt(st.nextToken());
            }
        }

        D[N] = P[N];
        for (int i = N - 1; i > 0; i--) {
            if(P[i] != 0) {
                D[i] = Math.max(D[i + 1], D[T[i]] + P[i]);
            } else {
                D[i] = D[i + 1];
            }
        }

        System.out.println(D[1]);
    }
}