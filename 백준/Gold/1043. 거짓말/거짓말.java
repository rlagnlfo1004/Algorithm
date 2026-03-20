/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1043                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1043                           #+#        #+#      #+#    */
/*   Solved: 2026/03/21 13:21:12 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        int[] party = new int[M + 1];

        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        int[] li = new int[k];
        for(int i = 0; i < k; i++) {
            li[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= M; i++) { // 파티 입력
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            int prev = 0;
            int next = 0;
            for(int j = 0; j < k; j++) {
                next = Integer.parseInt(st.nextToken());
                if(j == 0) {
                    party[i] = next;
                } else {
                    union(prev, next);
                }
                prev = next;
            }
        }

        int result = M;
        for(int i = 1; i <= M; i++) {
            int p = find(party[i]);
            for(int n : li) {
                if(find(n) == p) {
                    result--;
                    break;
                }
            }
        }

        System.out.println(result);
        br.close();
    }

    static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA != parentB) {
            parent[parentB] = parentA;
        }
    }
}