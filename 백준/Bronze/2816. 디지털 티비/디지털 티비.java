/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2816                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2816                           #+#        #+#      #+#    */
/*   Solved: 2026/02/27 14:07:42 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String[] A;
    static int index = 0;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new String[N];
        for (int  i = 0; i < N; i++) {
            A[i] = br.readLine();
        }

        while(!A[index].equals("KBS1")) func1();

        while(index != 0) func4();

        if(A[1].equals("KBS2")) {
            bw.flush();
            return;
        }

        while(!A[index].equals("KBS2")) func1();

        while(index != 1) func4();

        bw.flush();
    }

    static int func1() throws IOException {
        if(index + 1 >= N) {
            return index;
        }

        bw.write('1');
        return ++index;
    }

    static int func2() throws IOException {
        if(index - 1 < 0) {
            return index;
        }

        bw.write('2');
        return --index;
    }
    
    static int func3() throws IOException {
        if(index + 1 >= N) {
            return index;
        }

        String temp = A[index];
        A[index] = A[index + 1];
        A[index + 1] = temp;

        bw.write('3');
        return ++index;
    }
    
    static int func4() throws IOException {
        if(index - 1 < 0) {
            return index;
        }

        String temp = A[index];
        A[index] = A[index - 1];
        A[index - 1] = temp;

        bw.write('4');
        return --index;
    }
}