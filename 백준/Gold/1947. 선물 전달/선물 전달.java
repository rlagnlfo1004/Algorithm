/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1947                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1947                           #+#        #+#      #+#    */
/*   Solved: 2026/01/31 21:28:58 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] D = new long[1_000_001];
        D[2] = 1;
        for (int i = 3; i <= N; i++) {
            D[i] = (i - 1) * (D[i - 2] + D[i - 1]) % 1_000_000_000;
        }
        System.out.println(D[N]);
    }
}