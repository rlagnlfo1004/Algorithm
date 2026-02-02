/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2342                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2342                           #+#        #+#      #+#    */
/*   Solved: 2026/02/02 15:04:45 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] map = {
            {0, 2, 2, 2, 2},
            {2, 1, 3, 4, 3},
            {2, 3, 1, 3, 4},
            {2, 4, 3, 1, 3},
            {2, 3, 4, 3, 1}
        };
        
        int[][][] D = new int[100_001][5][5];
        for (int i = 0; i <= 100_000; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    D[i][j][k] = 1_000_000;
                }
            }
        }

        D[0][0][0] = 0;
        int step = 1;
        while(true) {
            int n = Integer.parseInt(st.nextToken());
            if(n == 0) break; // 입력 종료

            for (int i = 0; i < 5; i++) {
                if(i == n) continue; // 두 발이 같은 위치 (불가능)

                for (int j = 0; j < 5; j++) {
                    D[step][i][n] = Math.min(D[step - 1][i][j] + map[j][n], D[step][i][n]);
                }

                for (int j = 0; j < 5; j++) {
                    D[step][n][i] = Math.min(D[step - 1][j][i] + map[j][n], D[step][n][i]);
                }
            }
            step++;
        }
        step--;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                min = Math.min(min, D[step][i][j]);
            }
        }
        System.out.println(min);
    }
}