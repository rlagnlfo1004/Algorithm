/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17298                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17298                          #+#        #+#      #+#    */
/*   Solved: 2026/03/08 23:21:18 by hrkim2001     ###          ###   ##.kr    */
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
        int[] result = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        for(int i = 0; i < N; i++) {
            bw.write(result[i] + " ");
        }
        bw.flush();
    }
}