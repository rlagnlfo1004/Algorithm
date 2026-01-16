/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1043                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1043                           #+#        #+#      #+#    */
/*   Solved: 2026/01/16 17:12:21 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static int[] truePeople;
    static boolean[] findTruePeople;
    static int[][] participant;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        findTruePeople = new boolean[N + 1];
        participant = new int[M][N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        truePeople = new int[k];
        for (int i = 0; i < k; i++) {
            truePeople[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                participant[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < k - 1; j++) {
                union(participant[i][j], participant[i][j + 1]);
            }
        }

        for (int i = 0; i < truePeople.length; i++) {
            findTruePeople[find(truePeople[i])] = true;
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if(!findTruePeople[find(participant[i][0])]) {
                count++;
            }
        }
        System.out.println(count);
    }

    static void union(int a, int b) {
        int index1 = find(a);
        int index2 = find(b);

        if(index1 != index2) {
            parent[index2] = index1;
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}