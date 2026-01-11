/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11689                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11689                          #+#        #+#      #+#    */
/*   Solved: 2026/01/11 21:40:30 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        long N = new Scanner(System.in).nextLong();

        long result = N;
        for (long i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                result -= result / i;

                while (N % i == 0) {
                    N /= i;
                }
            }
        }

        if(N > 1) {
            result -= result / N;
        }

        System.out.println(result);
    }
}