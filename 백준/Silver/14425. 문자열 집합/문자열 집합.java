/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14425                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14425                          #+#        #+#      #+#    */
/*   Solved: 2026/01/23 16:32:13 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node root = new Node();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Node now = root;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if(now.next[c - 'a'] == null) {
                    now.next[c - 'a'] = new Node();
                }
                now = now.next[c - 'a'];

                if(j == str.length() - 1) {
                    now.isEnd = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            Node now = root;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if(now.next[c - 'a'] == null) {
                    break;
                }
                now = now.next[c - 'a'];

                if(j == str.length() - 1 && now.isEnd) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static class Node {
        Node[] next = new Node[26];
        boolean isEnd;
    }
}