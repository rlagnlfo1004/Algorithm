/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1717                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1717                           #+#        #+#      #+#    */
/*   Solved: 2026/03/17 23:16:58 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for(int i = 0; i <= n; i++) parent[i] = i;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(x == 0) union(a, b);
            else if(x == 1) {
                if(find(a) == find(b)) bw.write("YES\n");
                else bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void union(int a, int b) {
        parent[find(b)] = find(a);
    }

    static int find(int a) {
        if(parent[a] == a) return a;

        parent[a] = find(parent[a]);
        return parent[a];
    }
}