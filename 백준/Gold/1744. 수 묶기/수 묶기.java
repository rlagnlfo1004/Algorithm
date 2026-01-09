/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1744                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1744                           #+#        #+#      #+#    */
/*   Solved: 2026/01/09 16:56:35 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        int zeroCount = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            if (num > 0) plusQueue.add(num);
            else if (num < 0) minusQueue.add(num);
            else zeroCount++;
        }
        
        int result = 0;
        while(plusQueue.size() >= 2) {
            int a = plusQueue.poll();
            int b = plusQueue.poll();

            if(a == 1 || b == 1) result += a + b;
            else result += a * b;
        }
        while(!plusQueue.isEmpty()) {
            result += plusQueue.poll();
        }
        
        while(minusQueue.size() >= 2) {
            int a = minusQueue.poll();
            int b = minusQueue.poll();

            result += a * b;
        }
        while(!minusQueue.isEmpty()) {
            if(zeroCount != 0) {
                minusQueue.poll();
            } else {
                result += minusQueue.poll();
            }
        }

        System.out.println(result);
    }
}