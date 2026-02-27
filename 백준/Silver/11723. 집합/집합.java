/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11723                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11723                          #+#        #+#      #+#    */
/*   Solved: 2026/02/27 14:47:13 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "add" : 
                    set.add(Integer.parseInt(st.nextToken()));
                    break;

                case "remove" :
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;

                case "check" :
                    if(set.contains(Integer.parseInt(st.nextToken()))) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;

                case "toggle" :
                    int num = Integer.parseInt(st.nextToken());
                    if(set.contains(num)) {
                        set.remove(num);
                    } else {
                        set.add(num);
                    }
                    break;

                case "all" :
                    set.clear();
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;

                case "empty" :
                    set.clear();
                    break;
            }
        }
        bw.flush();
    }
}