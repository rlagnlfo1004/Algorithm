/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2252                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2252                           #+#        #+#      #+#    */
/*   Solved: 2026/01/17 19:56:53 by hrkim2001     ###          ###   ##.kr    */
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
        ArrayList<Integer>[] A = new ArrayList[N + 1];
        int[] D = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            D[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (D[i] == 0) {
                q.add(i);
                D[i] = -1;
            }
        }
        while (!q.isEmpty()) {
            int a = q.poll();
            bw.write(a + " ");
            for (int b : A[a]) {
                D[b]--;
            }

            for (int i = 1; i <= N; i++) {
                if (D[i] == 0) {
                    q.add(i);
                    D[i] = -1;
                }
            }
        }

        bw.flush();
        bw.close();
    }
}