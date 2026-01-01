/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11720                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11720                          #+#        #+#      #+#    */
/*   Solved: 2026/01/01 10:38:56 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();


        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (char c : cNum) {
            sum += c - '0';
        }

        System.out.println(sum);
    }
}