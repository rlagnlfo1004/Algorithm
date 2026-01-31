/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1463                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1463                           #+#        #+#      #+#    */
/*   Solved: 2026/01/31 22:26:42 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] D = new int[1_000_001];
        D[1] = 0;
        
        for (int i = 2; i <= N; i++) {
            D[i] = D[i - 1] + 1;

            if(i % 2 == 0) D[i] = Math.min(D[i], D[i / 2] + 1);
            if(i % 3 == 0) D[i] = Math.min(D[i], D[i / 3] + 1);
        }

        System.out.println(D[N]);
    }
}