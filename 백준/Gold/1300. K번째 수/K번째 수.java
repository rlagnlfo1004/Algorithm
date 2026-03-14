/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1300                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1300                           #+#        #+#      #+#    */
/*   Solved: 2026/03/14 16:02:09 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k = sc.nextInt();

        int start = 1;
        int end = k;
        int ans = 0;

        while(start <= end) {
            int count = 0;
            int middle = (start + end) / 2;

            for(int i = 1; i <= N; i++) {
                count += Math.min(middle / i, N);
            }
            
            if(count < k) {
                start = middle + 1;
            } else {
                end = middle - 1;
                ans = middle;
            }
        }

        System.out.println(ans);
        sc.close();
    }
}