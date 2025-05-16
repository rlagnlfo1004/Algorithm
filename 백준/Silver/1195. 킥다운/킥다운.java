
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1195                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1195                           #+#        #+#      #+#    */
/*   Solved: 2025/05/13 01:31:01 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        if (first.length() < second.length()) {
            String temp = first;
            first = second;
            second = temp;
        }

        int min = first.length() + second.length();
        int i, j, index;
        for (i = -second.length(); i < first.length(); i++) {
            for (j = 0; j < second.length(); j++) {

                char firstChar = '0';
                index = i + j;
                if (i + j >= 0 && i + j < first.length()) {
                    if(i + j < first.length()) {
                        firstChar = first.charAt(index);
                    }
                }

                if (firstChar + second.charAt(j) > '1' + '2') {
                    break;
                }

                if (j == second.length() - 1) {
                    int len = 0;
                    if (i < 0) {
                        len = first.length() - i;
                    } else if (i + second.length() > first.length()) {
                        len = i + second.length();
                    } else {
                        len = first.length();
                    }

                    if (min > len) {
                        min = len;
                    }
                }
            }
        }

        System.out.println(min);
    }
}