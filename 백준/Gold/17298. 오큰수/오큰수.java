/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17298                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17298                          #+#        #+#      #+#    */
/*   Solved: 2026/01/04 13:55:16 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[N];
        stack.push(0);
        
        for (int i = 1; i < N; i++) {
            while(!stack.empty() && A[i] > A[stack.peek()]) {
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            if(result[i] == 0) {
                bw.write("-1 ");
            } else {
                bw.write(result[i] + " ");
            }
        }
        br.close();
        bw.flush();
    }
}