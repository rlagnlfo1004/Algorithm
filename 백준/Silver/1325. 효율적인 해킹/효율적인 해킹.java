/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1325                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1325                           #+#        #+#      #+#    */
/*   Solved: 2026/03/15 20:39:33 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] A;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        A = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) A[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[b].add(a);
        }

        int max = 0;
        int[] result = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            result[i] = BFS(i);
            max = Math.max(max, result[i]);
        }

        for(int i = 1; i <= N; i++) {
            if(result[i] == max) bw.write(i + " ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    static int BFS(int s) {
        int[] q = new int[N + 1]; 
        int head = 0;
        int tail = 0;

        q[tail++] = s;
        visited[s] = s;
        int count = 0;

        while(head < tail) {
            int now = q[head++];

            for(int next : A[now]) {
                if(visited[next] != s) {
                    visited[next] = s;
                    q[tail++] = next;
                    count++;
                }
            }
        }
        return count;
    }
}