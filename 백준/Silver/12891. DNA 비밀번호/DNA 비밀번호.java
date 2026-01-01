/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 12891                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/12891                          #+#        #+#      #+#    */
/*   Solved: 2026/01/01 13:59:32 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int checkCount;
    static int[] myCount;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        char[] A = new char[S];
        A = br.readLine().toCharArray();

        myCount = new int[4];
        checkCount = 0;

        check = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            check[i] = Integer.parseInt(st.nextToken());
            if(check[i] == 0) {
                checkCount++;
            }
        }

        for(int i = 0; i < P; i++) {
            add(A[i]);
        }

        int result = 0;
        if(checkCount == 4) {
            result++;
        }

        for(int i=P; i<S; i++) {
            int j = i - P;
            add(A[i]);
            remove(A[j]);
            if(checkCount == 4) {
                result++;
            }
        }
        System.out.println(result);
        br.close();
    }

    private static void add(char c) {
        switch(c) {
            case 'A' :
                myCount[0]++;
                if(myCount[0] == check[0]) {
                    checkCount++;
                }
                break;
            case 'C' :
                myCount[1]++;
                if(myCount[1] == check[1]) {
                    checkCount++;
                }
                break;
            case 'G' :
                myCount[2]++;
                if(myCount[2] == check[2]) {
                    checkCount++;
                }
                break;
            case 'T' :
                myCount[3]++;
                if(myCount[3] == check[3]) {
                    checkCount++;
                }
                break;
        }
    }

    private static void remove(char c) {
        switch(c) {
            case 'A' :
                if(myCount[0] == check[0]) {
                    checkCount--;
                }
                myCount[0]--;
                break;
            case 'C' :
                if(myCount[1] == check[1]) {
                    checkCount--;
                }
                myCount[1]--;
                break;
            case 'G' :
                if(myCount[2] == check[2]) {
                    checkCount--;
                }
                myCount[2]--;
                break;
            case 'T' :
                if(myCount[3] == check[3]) {
                    checkCount--;
                }
                myCount[3]--;
                break;
        }
    }
}