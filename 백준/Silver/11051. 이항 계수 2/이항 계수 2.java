/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11051                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11051                          #+#        #+#      #+#    */
/*   Solved: 2026/01/28 14:55:57 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] D = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            D[i][0] = 1;
            D[i][1] = i;
            D[i][i] = 1;
        }

        for (int i = 3; i <= N; i++) {
            for (int j = 2; j < i; j++) {
                D[i][j] = (D[i - 1][j] + D[i - 1][j - 1] ) % 10_007;
            }
        }

        System.out.println(D[N][K]);
    }
}