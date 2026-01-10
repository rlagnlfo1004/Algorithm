/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1931                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1931                           #+#        #+#      #+#    */
/*   Solved: 2026/01/11 00:30:26 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] A = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] s, int[] e) {
                if(s[1] == e[1]) { // 종료 시간 동일
                    return s[0] - e[0];
                } else {
                    return s[1] - e[1];
                }
            }
        });

        int count = 0;
        int time = 0;
        for (int i = 0; i < N; i++) {
            if (A[i][0] >= time) {
                count++;
                time = A[i][1];
            }
        }
        System.out.println(count);
    }
}