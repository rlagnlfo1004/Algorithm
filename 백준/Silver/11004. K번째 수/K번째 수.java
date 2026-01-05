/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11004                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11004                          #+#        #+#      #+#    */
/*   Solved: 2026/01/05 13:15:05 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(A, 0, N-1, K-1);
        System.out.println(A[K-1]);
    }

    public static void quickSort(int[] A, int start, int end, int k) {
        if (start < end) {
            int pivot = partition(A, start, end);
            if(pivot == k) return;
            else if (k < pivot) quickSort(A, start, pivot - 1, k);
            else quickSort(A, pivot + 1, end, k);
        }
    }

    public static int partition(int A[], int start, int end) {
        if(start + 1 == end) {
            if(A[start] > A[end]) swap(A, start, end);
            return end;
        }

        swap(A, (start + end) / 2, start);
        int pivot = A[start];
        int i = start + 1, j = end;
        while(i <= j) {
            while (i <= end && pivot > A[i]) i++;
            while (j >= start + 1 && pivot < A[j]) j--;

            if(i <= j) swap(A, i++, j--);
        }

        swap(A, start, j);
        return j;
    }

    public static void swap(int A[], int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}