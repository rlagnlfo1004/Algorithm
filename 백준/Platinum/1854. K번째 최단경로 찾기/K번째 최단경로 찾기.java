/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1854                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1854                           #+#        #+#      #+#    */
/*   Solved: 2026/01/18 21:17:16 by hrkim2001     ###          ###   ##.kr    */
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
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> A = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            A.get(a).add(new Node(b, c));
        }

        PriorityQueue<Integer>[] distance = new PriorityQueue[N + 1];
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        for (int i = 0; i <= N; i++) {
            distance[i] = new PriorityQueue<>(K, comparator);
        }
        distance[1].add(0);

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0));

        while(!q.isEmpty()) {
            Node now = q.poll();
            for(Node next : A.get(now.v)) {
                if (distance[next.v].size() < K) {
                    distance[next.v].add(now.c + next.c);
                    q.add(new Node(next.v, now.c + next.c));
                } else if(distance[next.v].peek() > now.c + next.c) {
                    distance[next.v].poll();
                    distance[next.v].add(now.c + next.c);
                    q.add(new Node(next.v, now.c + next.c));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (distance[i].size() == K) {
                bw.write(distance[i].peek() + "\n");
            } else {
                bw.write(-1 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node implements Comparable<Node> {
        int v, c;
        public Node(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Node n) {
            return this.v - n.v;
        }
    }
}