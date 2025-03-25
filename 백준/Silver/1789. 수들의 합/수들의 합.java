/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1789                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1789                           #+#        #+#      #+#    */
/*   Solved: 2025/03/26 01:08:20 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long S = Long.parseLong(br.readLine());
        long N = 0;
        long num = 0;

        while(S >= num) {
            N++;
            num += N;
        }
        if(S < num)
            N--;

        bw.write(String.valueOf(N));
        bw.flush();
    }
}