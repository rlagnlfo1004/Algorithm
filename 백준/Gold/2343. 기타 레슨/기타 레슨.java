/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2343                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2343                           #+#        #+#      #+#    */
/*   Solved: 2026/01/08 14:02:23 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;;
        for (int i = 0; i < N; i++) {
            if(start < A[i]) start = A[i];
            end += A[i];
        }

        while (start <= end) {
            int middle = (start + end) / 2;
            int count = 1;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if(sum + A[i] > middle) {
                    sum = A[i];
                    count++;
                } else {
                    sum += A[i];
                }
            }

            if (count > M) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        System.out.println(start);
    }
}