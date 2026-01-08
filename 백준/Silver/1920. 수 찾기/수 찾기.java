/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1920                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1920                           #+#        #+#      #+#    */
/*   Solved: 2026/01/08 12:16:16 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        br.close();
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = N-1;
            boolean isFound = false;

            while(start <= end) {
                int middle = (start + end) / 2;

                if(A[middle] == target) {
                    isFound = true;
                    break;
                } else if (A[middle] > target) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }

            if(isFound) {
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}