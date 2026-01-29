/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1722                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1722                           #+#        #+#      #+#    */
/*   Solved: 2026/01/29 17:43:38 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        long[] F = new long[21];
        boolean[] visited = new boolean[21];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());

        F[0] = 1;
        for (int i = 1; i <= N; i++) {
            F[i] = F[i - 1] * i;
        }

        if(Q == 1) {
            long K = Long.parseLong(st.nextToken());
            for (int i = 1; i <= N; i++) {
                for (int j = 1, cnt = 1; j <= N; j++) {
                    if(visited[j] == true) {
                        continue;
                    }
                    if(K <= F[N - i] * cnt) {
                        K -= F[N - i] * (cnt - 1);
                        System.out.print(j + " ");
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
        } else {
            long K = 1;
            for (int i = 1; i <= N; i++) {
                int num = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for(int j = 1; j <= N; j++) {
                    if(visited[j] == true) {
                        continue;
                    }
                    if(num == j) {
                        K += cnt * F[N - i];
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            System.out.println(K);
        }
    }
}