/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11049                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11049                          #+#        #+#      #+#    */
/*   Solved: 2026/02/03 14:29:42 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] row;
    static int[] col;
    static int[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        row = new int[N + 1];
        col = new int[N + 1];
        D = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++)
            for (int j = 0; j <= N; j++)
                if(i != j)
                    D[i][j] = -1;

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            row[i] = Integer.parseInt(st.nextToken());
            col[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(execute(1, N));
    }

    static int execute(int s, int e) {

        if(D[s][e] != -1) {
            return D[s][e];
        }

        D[s][e] = Integer.MAX_VALUE;
        for (int i = s + 1; i <= e; i++) {
            D[s][e] = Math.min(D[s][e], execute(s, i - 1) + execute(i, e) + row[s] * row[i] * col[e]);
        }

        return D[s][e];
    }
}