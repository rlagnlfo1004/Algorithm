/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1016                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1016                           #+#        #+#      #+#    */
/*   Solved: 2026/01/11 20:58:07 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long min = sc.nextLong();
        long max = sc.nextLong();

        boolean[] A = new boolean[(int)(max - min + 1)];

        for (long i = 2; i <= Math.sqrt(max); i++) {
            long num = i * i;
            long start = min / num;
            if (min % num != 0) start++;

            for (long j = start; num * j <= max; j++) {
                A[(int)(num * j - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if(!A[i]) count++;
        }
        System.out.println(count);
    }
}