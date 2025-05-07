/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1654                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1654                           #+#        #+#      #+#    */
/*   Solved: 2025/05/07 15:01:00 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lan = new int[K];
        long right = 0;
        for(int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            if(lan[i] > right) {
                right = lan[i];
            }
        }

        long left = 1;
        long mid, count;
        while(left <= right) {
            count = 0;
            mid = (left + right) / 2;

            for(int i = 0; i < K; i++) {
                count += lan[i] / mid;
            }
            if(count >= N) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}