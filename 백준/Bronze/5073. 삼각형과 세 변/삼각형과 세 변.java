/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 5073                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/5073                           #+#        #+#      #+#    */
/*   Solved: 2026/02/26 22:58:32 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            int[] A = new int[3];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            if(A[0] == A[1] || A[1] == A[2]) {
                if(A[0] == A[2]) {
                    if(A[1] == 0) break;
                    bw.write("Equilateral\n");
                } else if(A[0] + A[1] > A[2]) bw.write("Isosceles\n");
                else bw.write("Invalid\n");
            } else if(A[0] + A[1] > A[2]) bw.write("Scalene\n");
            else bw.write("Invalid\n");
        }

        bw.flush();
    }
}