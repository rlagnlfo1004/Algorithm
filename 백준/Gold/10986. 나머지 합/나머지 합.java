/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10986                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10986                          #+#        #+#      #+#    */
/*   Solved: 2025/04/06 22:55:16 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] sArr = new long[N + 1];
        long[] mArr = new long[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            sArr[i] = sArr[i - 1] + Integer.parseInt(st.nextToken());
            int remainder = (int) (sArr[i] % M);
            mArr[remainder]++;
        }

        long count = 0;
        for (int i = 0; i < M; i++) {
            if(mArr[i] > 1) {
                count += mArr[i] * (mArr[i] - 1) / 2;
            }
        }
        System.out.println(count + mArr[0]);
    }
}