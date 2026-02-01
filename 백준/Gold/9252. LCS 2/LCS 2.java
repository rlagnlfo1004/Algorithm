/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9252                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9252                           #+#        #+#      #+#    */
/*   Solved: 2026/02/02 01:58:55 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    
    static String A, B;
    static int[][] D;
    static ArrayList<Character> path;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextLine();
        B = sc.nextLine();
        D = new int[A.length() + 1][B.length() + 1];

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    D[i][j] = D[i - 1][j - 1] + 1;
                } else {
                    D[i][j] = Math.max(D[i - 1][j], D[i][j - 1]);
                }
            }
        }
        System.out.println(D[A.length()][B.length()]);

        path = new ArrayList<>();
        findPath(A.length(), B.length());

        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i));
        }
    }

    private static void findPath(int row, int col) {
        if(row == 0 || col == 0) {
            return;
        }
        else if(A.charAt(row - 1) == B.charAt(col - 1)) {
            path.add(A.charAt(row - 1));
            findPath(row - 1, col - 1);
        } else if(D[row - 1][col] > D[row][col - 1]) {
            findPath(row - 1, col);
        } else {
            findPath(row, col - 1);
        }
    }
}