/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1105                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1105                           #+#        #+#      #+#    */
/*   Solved: 2025/05/20 00:41:22 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();
        int count = 0;

        if(a.length() < b.length()) {
            System.out.println(count);
            return;
        }

        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                break;
            }
            if(a.charAt(i) == '8') {
                count++;
            }
        }
        System.out.println(count);
    }
}