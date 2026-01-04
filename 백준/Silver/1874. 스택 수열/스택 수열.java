/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1874                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1874                           #+#        #+#      #+#    */
/*   Solved: 2026/01/04 13:21:44 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1;
        boolean result = true;

        for (int i = 0; i < n; i++) {
            while(stack.empty() || A[i] >= num) {
                stack.push(num);
                num++;
                bf.append("+\n");
            }

            int stackNum = stack.pop();
            if(stackNum < A[i]) {
                result = false;
                System.out.println("NO");
                break;
            } else{
                bf.append("-\n");
            }
        }
        if(result) {
            System.out.println(bf.toString());
        }
    }
}