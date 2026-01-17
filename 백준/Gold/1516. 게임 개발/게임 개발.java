/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1516                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1516                           #+#        #+#      #+#    */
/*   Solved: 2026/01/17 20:31:07 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] C = new int[N + 1];
        int[] D = new int[N + 1];
        ArrayList<Integer>[] A = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            C[i] = sc.nextInt();

            while(true) {
                int v = sc.nextInt();
                if (v == -1) break;

                A[v].add(i);
                D[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(D[i] == 0) {
                q.add(i);
            }
        }

        int[] result = new int[N + 1];
        while(!q.isEmpty()) {
            int now = q.poll();
            for (int next : A[now]) {
                D[next]--;
                result[next] = Math.max(result[now] + C[now], result[next]);
                if(D[next] == 0) q.add(next); 
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i] + C[i]);
        }
    }
}