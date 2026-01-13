/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1850                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1850                           #+#        #+#      #+#    */
/*   Solved: 2026/01/13 13:50:10 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        if (A < B) {
            long temp = A;
            A = B;
            B = temp;
        }

        while (true) {
            long mod = A % B;
            if(mod == 0) {
                break;
            }
            A = B;
            B = mod;
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (long i = 0; i < B; i++) {
            bw.write("1");
        }
        bw.flush();
        bw.close();
    }
}