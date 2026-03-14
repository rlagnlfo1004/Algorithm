/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11047                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11047                          #+#        #+#      #+#    */
/*   Solved: 2026/03/14 21:34:09 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        int sum = K;
        int i = N - 1;

        while(sum > 0) {
            while(A[i] > sum) {
                i--;
            }
            int temp = sum / A[i];
            result += temp;
            sum -= temp * A[i];
        }
        System.out.println(result);
        br.close();
    }
}