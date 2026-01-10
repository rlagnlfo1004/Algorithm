/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1541                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1541                           #+#        #+#      #+#    */
/*   Solved: 2026/01/11 00:54:34 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str = new Scanner(System.in).next();
        String[] A = str.split("[-]");

        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if(i == 0) {
                result += add(A[i]);
            } else {
                result -= add(A[i]);
            }
        }

        System.out.println(result);
    }

    static int add(String str) {
        String[] S = str.split("[+]");
        int sum = 0;
        for (int i = 0; i < S.length; i++) {
            sum += Integer.parseInt(S[i]);
        }
        return sum;
    }
}