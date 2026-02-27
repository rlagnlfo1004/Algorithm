/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1157                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1157                           #+#        #+#      #+#    */
/*   Solved: 2026/02/26 23:44:33 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().toUpperCase();
        int[] count = new int[27];
        int max = 0;
        char maxChar = 'a';
        boolean result = false;

        for(int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'A';
            count[index]++;

            if (count[index] > max) {
                max = count[index];
                maxChar = str.charAt(i);
                result = true;
            } else if(count[index] == max) {
                result = false;
            }
        }

        if(result) System.out.println(maxChar);
        else System.out.println('?');
    }
}