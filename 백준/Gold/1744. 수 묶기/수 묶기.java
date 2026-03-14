/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1744                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1744                           #+#        #+#      #+#    */
/*   Solved: 2026/03/14 22:10:34 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int zero = 0;

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > 0) {
                plus.add(num);
            } else if(num < 0) {
                minus.add(num);
            } else {
                zero++;
            }
        }
        
        int result = 0;
        while(plus.size() > 1) {
            int a = plus.poll();
            int b = plus.poll();

            if(b == 1) {
                result += a;
                result += b;
                break;
            } else {
                result += a * b;
            }
        }

        while(!plus.isEmpty()) {
            result += plus.poll();
        }

        while(minus.size() > 1) {
            result += minus.poll() * minus.poll();
        }

        while(!minus.isEmpty() && zero > 0) {
            minus.poll();
            zero--;
        }

        while(!minus.isEmpty()) {
            result += minus.poll();
        }

        System.out.println(result);
        br.close();
    }
}