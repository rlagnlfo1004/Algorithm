/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1976                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1976                           #+#        #+#      #+#    */
/*   Solved: 2026/03/17 23:52:18 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for(int i = 1; i <= N; i++) parent[i] = i;

        StringTokenizer st;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= N; j++) {
                if(st.nextToken().equals("1") && i < j) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] path = new int[M];
        path[0] = Integer.parseInt(st.nextToken());

        boolean result = false;
        for(int i = 1; i < M; i++) {
            path[i] = Integer.parseInt(st.nextToken());
            if(find(path[i]) != find(path[i - 1])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        br.close();
    }

    static int find(int a) {
        if(a == parent[a]) return a;
        
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        parent[find(b)] = find(a);
    }
}