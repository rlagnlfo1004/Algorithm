/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2252                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2252                           #+#        #+#      #+#    */
/*   Solved: 2026/04/06 15:06:49 by hrkim2001     ###          ###   ##.kr    */
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
        for(int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        int[] D = new int[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            D[b]++;
        }

        Queue<Integer> Q = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            if(D[i] == 0) {
                Q.add(i);
            }
        }

        while(!Q.isEmpty()) {
            int now = Q.poll();
            bw.write(now + " ");

            for(int next : A[now]) {
                D[next]--;
                if(D[next] == 0) {
                    Q.add(next);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}