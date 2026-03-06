/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 12891                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/12891                          #+#        #+#      #+#    */
/*   Solved: 2026/03/06 17:12:55 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        String password = br.readLine();

        st = new StringTokenizer(br.readLine());
        int check[] = new int[4];
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        int myCheck[] = new int[4];
        for (int i = 0; i < P; i++) {
            myCheck[convert(password.charAt(i))]++;
        }

        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (check[i] <= myCheck[i]) count++;
        }

        int result = 0;
        if (count == 4) result++;

        for (int i = P; i < S; i++) {
            int old = convert(password.charAt(i - P));
            int next = convert(password.charAt(i));

            if (myCheck[old] == check[old]) count--;
            myCheck[old]--;

            myCheck[next]++;
            if (myCheck[next] == check[next]) count++;

            if(count == 4) result++;
        }

        System.out.println(result);
    }

    static int convert(char c) {
        switch(c) {
            case 'A' : 
                return 0;
            case 'C' :
                return 1;
            case 'G' :
                return 2;
            case 'T' :
                return 3;
        }

        return -1;
    }
}