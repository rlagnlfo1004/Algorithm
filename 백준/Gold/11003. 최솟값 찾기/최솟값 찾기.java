/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11003                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11003                          #+#        #+#      #+#    */
/*   Solved: 2026/03/07 12:56:31 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> A = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            Node node = new Node(i, Integer.parseInt(st.nextToken()));

            while (!A.isEmpty() && A.getLast().value > node.value) {
                A.removeLast();
            }

            A.addLast(node);

            if(A.getFirst().index <= i - L) {
                A.removeFirst();
            }

            bw.write(A.getFirst().value + " ");
        }

        bw.flush();
    }

    static class Node {
        int index;
        int value;

        public Node (int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}