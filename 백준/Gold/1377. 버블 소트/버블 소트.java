/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1377                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1377                           #+#        #+#      #+#    */
/*   Solved: 2026/01/04 22:53:49 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Node[] A = new Node[N];
        for (int i = 0; i < N; i++) {
            A[i] = new Node(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(A);
        
        int max = 0;
        for (int i = 0; i < N; i++) {
            if(A[i].index - i > max) {
                max = A[i].index - i;
            }
        }
        System.out.println(max + 1);
    }

    static class Node implements Comparable<Node> {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}