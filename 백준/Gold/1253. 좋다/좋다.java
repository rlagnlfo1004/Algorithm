/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1253                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1253                           #+#        #+#      #+#    */
/*   Solved: 2025/04/13 00:45:40 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        long[] arr = new long[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;

        for(int k = 0; k < N; k++) {
            int i = 0;
            int j = N - 1;

            while(i < j) {
                long sum = arr[i] + arr[j];
                
                if(sum > arr[k]) {
                    j--;
                } else if(sum < arr[k]) {
                    i++;
                } else {
                    if(i != k && j != k) {
                        count++;
                        break;
                    } else if(i == k) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
        }
        System.out.println(count);
    }
}