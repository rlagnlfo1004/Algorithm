/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 13251                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/13251                          #+#        #+#      #+#    */
/*   Solved: 2026/01/28 19:36:21 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int[] D = new int[M];

        int N = 0;
        for (int i = 0; i < M; i++) {
            D[i] =  sc.nextInt();
            N += D[i];
        }

        int K = sc.nextInt();
        double result = 0.0;
        for (int i = 0; i < M; i++) {
            double p = 1.0;
            for (int j = 0; j < K; j++) {
                p *= (double) (D[i] - j) / (double) (N - j);
            }
            result += p;
        }

        System.out.println(result);
    }
}