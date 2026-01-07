/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1167                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1167                           #+#        #+#      #+#    */
/*   Solved: 2026/01/08 00:42:47 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    static int V;
    static ArrayList<Node>[] A;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        A = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;
            
            while(true) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) break;
                A[index].add(new Node(num - 1, Integer.parseInt(st.nextToken())));
            }
        }

        visited = new boolean[V];
        distance = new int[V];
        BFS(0);

        int max = 0;
        for (int i = 0; i < V; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }

        visited = new boolean[V];
        distance = new int[V];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[V-1]);
    }

    static class Node {
        int v;
        int d;

        public Node (int v, int d) {
            this.v = v;
            this.d = d;
        }
    }

    static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;

        while(!queue.isEmpty()) {
            int nowIndex = queue.poll();
            for (Node node : A[nowIndex]) {
                int v = node.v;
                int d = node.d;

                if(!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                    distance[v] = distance[nowIndex] + d;
                }
            }
        }
    }
}