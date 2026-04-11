
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11657                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11657                          #+#        #+#      #+#    */
/*   Solved: 2026/04/12 03:38:57 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] D = new long[N + 1];
        Arrays.fill(D, Integer.MAX_VALUE);
        D[1] = 0;

        int[][] A = new int[M][3];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
            A[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int k = 1; k < N; k++) {
            for(int i = 0; i < M; i++) {
                if(D[A[i][0]] != Integer.MAX_VALUE) {
                    long temp = D[A[i][0]] + A[i][2];
                    if(temp < D[A[i][1]]) D[A[i][1]] = temp;
                }
            }
        }

        boolean m = false;
        for(int i = 0; i < M; i++)
            if(D[A[i][0]] != Integer.MAX_VALUE && D[A[i][0]] + A[i][2] < D[A[i][1]])
                m = true;
        
        if(m) {
            bw.write("-1\n");
        } else {
            for(int i = 2; i <= N; i++) {
                if(D[i] == Integer.MAX_VALUE) bw.write("-1\n");
                else bw.write(D[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}