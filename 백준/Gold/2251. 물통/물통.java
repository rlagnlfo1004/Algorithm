/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2251                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2251                           #+#        #+#      #+#    */
/*   Solved: 2026/03/17 21:01:14 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {0, 0, 1, 1, 2, 2};
    static int[] dy = {1, 2, 0, 2, 0, 1};
    static int[] W = new int[3];
    static boolean[][] visited = new boolean[201][201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 3; i++) {
            W[i] = Integer.parseInt(st.nextToken());
        }

        SortedSet<Integer> set = new TreeSet<>();
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {0, 0, W[2]});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == 0) set.add(now[2]);

            for(int i = 0; i < 6; i++) {
                int[] next = process(i, now);
                if(next != null && !visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.add(next);
                }
            }
        }

        for(int i : set) bw.write(i + " ");
        bw.flush();
        bw.close();
        br.close();
    }

    static int[] process(int i, int[] now) {
        if(now[dx[i]] > 0 && now[dy[i]] < W[dy[i]]) {
            int temp = Math.min(W[dy[i]] - now[dy[i]], now[dx[i]]);

            int[] next = now.clone();
            next[dx[i]] -= temp;
            next[dy[i]] += temp;
            return next;
        }
        return null;
    }
}