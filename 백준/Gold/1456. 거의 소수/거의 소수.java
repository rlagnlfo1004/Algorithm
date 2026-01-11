/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1456                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1456                           #+#        #+#      #+#    */
/*   Solved: 2026/01/11 19:45:25 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        long[] S = new long[10000001];
        for (int i = 2; i < S.length; i++) {
            S[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(S.length); i++) {
            if(S[i] == 0) {
                continue;
            }
            for (int j = i + i; j < S.length; j += i) {
                S[j] = 0;
            }
        }

        int count = 0;
        for (int i = 2; i < S.length; i++) {
            if (S[i] != 0) {
                long temp = i;
                
                while((double)i <= (double)B / (double)temp) {
                    if((double)i >= (double)A / (double)temp) count++;
                    temp *= i;
                }
            }
        }

        System.out.println(count);
    }
}