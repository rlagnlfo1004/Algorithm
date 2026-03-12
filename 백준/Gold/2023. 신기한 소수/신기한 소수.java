/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2023                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2023                           #+#        #+#      #+#    */
/*   Solved: 2026/03/12 23:35:46 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = {1, 3, 7, 9};
    static int[] sx = {2, 3, 5, 7};
    static int N;
    static BufferedWriter bw;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());

        for(int x : sx) {
            isPrime(x, 1);
        }
        bw.flush();
    }

    static void isPrime(int n, int j) throws IOException {
        for(int i = 2; i <= n / 2; i++) {
            if(n % i == 0) return;
        }

        if(j != N) {
            for(int x : dx) {
                isPrime(n * 10 + x, j + 1);
            }
        } else {
            bw.write(n + "\n");
        }
    }
}