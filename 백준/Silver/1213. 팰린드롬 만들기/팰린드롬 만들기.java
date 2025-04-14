
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1213                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1213                           #+#        #+#      #+#    */
/*   Solved: 2025/04/14 12:08:22 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'A']++;
        }

        int odd_count = 0;
        int odd_index = 1;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                odd_index = i;
                odd_count++;
            }
        }

        if ((str.length() % 2 == 0 && odd_count > 0) || 
                (str.length() % 2 == 1 && odd_count != 1)) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i] / 2; j++)
                System.out.printf("%c", 'A' + i);
        }

        if (odd_count == 1) 
            System.out.printf("%c", 'A' + odd_index);

        for (int i = 25; i >= 0; i--) {
            for(int j = 0; j < count[i] / 2; j++)
                System.out.printf("%c", 'A' + i);
        }
        br.close();
    }
}