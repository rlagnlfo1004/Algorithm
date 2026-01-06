/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2751                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2751                           #+#        #+#      #+#    */
/*   Solved: 2026/01/06 13:12:02 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    public static int[] A, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        temp = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N-1);
        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        br.close();
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1) return;
        int middle = (start + end) / 2;
        mergeSort(start, middle);
        mergeSort(middle + 1, end);

        for (int i = start; i <= end; i++) {
            temp[i] = A[i];
        }

        int k = start;
        int index1 = start;
        int index2 = middle + 1;
        while(index1 <= middle && index2 <= end) {
            if(temp[index1] < temp[index2]) A[k++] = temp[index1++];
            else A[k++] = temp[index2++];
        }

        while(index1 <= middle) A[k++] = temp[index1++];
        while(index2 <= end) A[k++] = temp[index2++];
    }
}