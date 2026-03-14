/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1715                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1715                           #+#        #+#      #+#    */
/*   Solved: 2026/03/14 21:57:35 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> Q = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            Q.add(Long.parseLong(br.readLine()));
        }

        long result = 0;
        while(Q.size() > 1) {
            long temp = Q.poll() + Q.poll();
            Q.add(temp);
            result += temp;
        }
        System.out.println(result);
        br.close();
    }
}