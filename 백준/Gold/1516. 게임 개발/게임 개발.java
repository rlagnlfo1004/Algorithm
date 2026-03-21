/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1516                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1516                           #+#        #+#      #+#    */
/*   Solved: 2026/03/21 23:52:48 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] D = new int[N + 1];
        int[] result = new int[N + 1];
        
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i = 0; i <= N; i++) A.add(new ArrayList<>());

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            result[i] = T[i];

            int e;
            while((e = Integer.parseInt(st.nextToken())) != -1) {
                A.get(e).add(i);
                D[i]++;
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(D[i] == 0) {
                Q.add(i);
            }
        }

        while(!Q.isEmpty()) {
            int now = Q.poll();
            for(int next : A.get(now)) {
                result[next] = Math.max(result[next], result[now] + T[next]);
                D[next]--;

                if(D[next] == 0) {
                    Q.add(next);
                }
            }
        }
        
        for(int i = 1; i <= N; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}