/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1516                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1516                           #+#        #+#      #+#    */
/*   Solved: 2026/04/06 22:14:33 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] A = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        int[] D = new int[N + 1];
        int[] W = new int[N + 1];
        int[] T = new int[N + 1];

        StringTokenizer st;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            T[i] = W[i];
            int k;
            while((k = Integer.parseInt(st.nextToken())) != -1) {
                A[k].add(i);
                D[i]++;
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(D[i] == 0) Q.add(i);
        }
        
        while(!Q.isEmpty()) {
            int now = Q.poll();

            for(int next : A[now]) {
                D[next]--;
                T[next] = Math.max(T[next], W[next] + T[now]);

                if(D[next] == 0) Q.add(next);
            }
        }

        for(int i = 1; i <= N; i++) {
            bw.write(T[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}