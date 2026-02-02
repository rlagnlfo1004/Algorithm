/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1915                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1915                           #+#        #+#      #+#    */
/*   Solved: 2026/02/02 13:52:31 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    static int[][] D;
    static int result = 0;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        D = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                D[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));

                if(D[i][j] == 1 && i > 0 && j > 0) {
                    D[i][j] = Math.min(D[i - 1][j - 1], Math.min(D[i][j - 1], D[i - 1][j])) + 1;
                }

                if(result < D[i][j]) {
                    result = D[i][j];
                }
            }
        }
        System.out.println(result * result);
    }
}