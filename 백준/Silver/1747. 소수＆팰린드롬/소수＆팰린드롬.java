/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1747                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1747                           #+#        #+#      #+#    */
/*   Solved: 2026/01/11 20:38:54 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = 10_000_000;

        int[] A = new int[max];
        for (int i = 2; i < max; i++) {
            A[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(max); i++) {
            if(A[i] == 0) continue;

            for (int j = i+i; j < max; j+=i) {
                if(j % i == 0) A[j] = 0;
            }
        }

        int i = N;
        while (true) {
            if(A[i] != 0) {
                if(isP(A[i])) {
                    break;
                }
            }
            i++;
        }
        System.out.println(A[i]);
    }

    static boolean isP(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            if(arr[s] != arr[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}