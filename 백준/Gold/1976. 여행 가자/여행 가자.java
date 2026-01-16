/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1976                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1976                           #+#        #+#      #+#    */
/*   Solved: 2026/01/16 15:40:51 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if(st.nextToken().equals("1")) {
                    union(i, j);
                }
            }
        }
        
        st = new StringTokenizer(br.readLine());
        int index = find(Integer.parseInt(st.nextToken()));
        boolean result = true;
        for (int i = 0; i < M - 1; i++) {
            if(index != find(Integer.parseInt(st.nextToken()))) {
                result = false;
            }
        }
        if(result) System.out.println("YES");
        else System.out.println("NO");
    }

    static void union(int i, int j) {
        int a = find(i);
        int b = find(j);

        if(a != b) {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if(parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }
}