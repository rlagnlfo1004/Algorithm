/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1934                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1934                           #+#        #+#      #+#    */
/*   Solved: 2026/01/13 13:41:38 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            System.out.println(A * B / gcd(A, B));
        }
    }

    static int gcd(int A, int B) {
        if (A < B) {
            int temp = A;
            A = B;
            B = temp;
        }

        while (true) {
            int mod = A % B;
            if(mod == 0) {
                return B;
            }
            A = B;
            B = mod;
        }
    }
}