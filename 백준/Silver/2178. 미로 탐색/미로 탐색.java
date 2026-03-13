/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2178                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2178                           #+#        #+#      #+#    */
/*   Solved: 2026/03/13 16:30:20 by hrkim2001     ###          ###   ##.kr    */
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

        int[][] A = new int[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                A[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.x == N - 1 && now.y == M - 1) break;

            for(int i = 0; i < 4; i++) {
                int nX = now.x + dx[i];
                int nY = now.y + dy[i];

                if(nX >= 0 && nY >= 0 && nX < N && nY < M && A[nX][nY] == 1) {
                    q.add(new Point(nX, nY));
                    A[nX][nY] = A[now.x][now.y] + 1;
                }
            }
        }

        System.out.println(A[N - 1][M - 1]);
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}