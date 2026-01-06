/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1517                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1517                           #+#        #+#      #+#    */
/*   Solved: 2026/01/06 13:58:50 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static int[] A, temp;
    public static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        temp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N-1);
        System.out.println(count);
    }

    public static void mergeSort(int s, int e) {
        if (e - s < 1) return;
        int m = (s + e) / 2;
        mergeSort(s, m);
        mergeSort(m + 1, e);

        for (int i = s; i <= e; i++) {
            temp[i] = A[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m + 1;
        while(index1 <= m && index2 <= e) {
            if(temp[index1] <= temp[index2]) A[k++] = temp[index1++];
            else {
                count += (long)(index2 - k);
                A[k++] = temp[index2++];
            }
        }

        while(index1 <= m) A[k++] = temp[index1++];
        while(index2 <= e) A[k++] = temp[index2++];
    }
}