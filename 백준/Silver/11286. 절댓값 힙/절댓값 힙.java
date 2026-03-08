/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11286                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11286                          #+#        #+#      #+#    */
/*   Solved: 2026/03/08 23:47:56 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> Q = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1) == Math.abs(o2)) {
                return o1 < o2 ? -1 : 1;
            } else {
                return Math.abs(o1) < Math.abs(o2) ? -1 : 1;
            }
        });

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(Q.isEmpty()) bw.write("0\n");
                else bw.write(Q.poll() + "\n");
            } else  {
                Q.add(num);
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}