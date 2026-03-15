/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 18352                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/18352                          #+#        #+#      #+#    */
/*   Solved: 2026/03/15 20:20:12 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());


        ArrayList<Integer>[] A = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) A[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        int[] visited = new int[N + 1];
        Queue<Integer> Q = new LinkedList<>();

        Q.add(X);
        while(!Q.isEmpty()) {
            int now = Q.poll();

            for(int next : A[now]) {
                if(visited[next] == 0 && next != X) {
                    Q.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }

        boolean result = false;
        for(int i = 1; i <= N; i++) {
            if(visited[i] == K) {
                System.out.println(i);
                result = true;
            }
        }
        if(!result) System.out.println(-1);
        br.close();
    }
}