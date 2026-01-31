/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2747                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2747                           #+#        #+#      #+#    */
/*   Solved: 2026/01/31 22:09:44 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if(N == 1) {
            System.out.println(1);
            return;
        }
        int[] D = new int[N + 1];
        D[1] = 1;
        for (int i = 2; i <= N; i++) {
            D[i] = D[i - 1] + D[i - 2];
        }

        System.out.println(D[N]);
    }
}