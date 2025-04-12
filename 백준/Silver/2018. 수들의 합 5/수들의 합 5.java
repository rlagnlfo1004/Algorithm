/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2018                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2018                           #+#        #+#      #+#    */
/*   Solved: 2025/04/12 23:38:32 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1;
        int end_index = 1;
        int start_index = 1;
        int sum = 1;

        while(end_index != N) {
            if(sum == N) {
                count++;
                end_index++;
                sum += end_index;
            } else if(sum > N) {
                sum -= start_index;
                start_index++;
            } else {
                end_index++;
                sum += end_index;
            }
        }
        System.out.println(count);
    }
}