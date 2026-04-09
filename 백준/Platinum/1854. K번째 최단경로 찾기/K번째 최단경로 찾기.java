/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1854                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1854                           #+#        #+#      #+#    */
/*   Solved: 2026/04/10 02:57:08 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> A = new ArrayList<>();
        for(int i = 0; i <= n; i++) A.add(new ArrayList<>());

        ArrayList<PriorityQueue<Integer>> result = new ArrayList<>();
        for(int i = 0; i <= n; i++) result.add(new PriorityQueue<>(k, (o1, o2) -> o2 - o1));
        result.get(1).add(0);
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            A.get(a).add(new Node(b, c));
        }

        PriorityQueue<Node> Q = new PriorityQueue<>();
        Q.add(new Node(1, 0));

        while(!Q.isEmpty()) {
            Node now = Q.poll();
            
            for(Node next : A.get(now.v)) {
                int weight = now.w + next.w;
                if(result.get(next.v).size() < k) {
                    result.get(next.v).add(weight);
                    Q.add(new Node(next.v, weight));
                } else if(result.get(next.v).peek() > weight) {
                    result.get(next.v).poll();
                    result.get(next.v).add(weight);
                    Q.add(new Node(next.v, weight));
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(result.get(i).size() < k) bw.write("-1\n");
            else bw.write(result.get(i).peek() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}