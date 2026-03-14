/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1541                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1541                           #+#        #+#      #+#    */
/*   Solved: 2026/03/14 23:25:25 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str = new Scanner(System.in).next();
        String[] A = str.split("[-]");

        int sum = add(A[0]);
        for(int i = 1; i < A.length; i++) {
            sum -= add(A[i]);
        }
        System.out.println(sum);
    }

    static int add(String str) {
        String[] A = str.split("[+]");
        int sum = 0;
        for(String s : A) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}