/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1948                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1948                           #+#        #+#      #+#    */
/*   Solved: 2026/01/18 15:06:49 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Node>[] A = new ArrayList[N + 1];
        ArrayList<Node>[] reverseA = new ArrayList[N + 1];
        int[] inDegree = new int[N + 1];
        int[] distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            reverseA[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            A[a].add(new Node(b, d));
            reverseA[b].add(new Node(a, d));

            inDegree[b]++;
        }

        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(startNode);
        while(!q.isEmpty()) {
            int now = q.poll();
            for (Node nextNode : A[now]) {
                inDegree[nextNode.v]--;
                distance[nextNode.v] = Math.max(distance[now] + nextNode.d, distance[nextNode.v]);
                if (inDegree[nextNode.v] == 0) {
                    q.add(nextNode.v);
                }
            }
        }

        int result = 0;
        boolean[] visited = new boolean[N + 1];
        q.add(endNode);
        visited[endNode] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            for (Node nextNode : reverseA[now]) {
                if(distance[now] == nextNode.d + distance[nextNode.v]) {
                    result++;
                    if (!visited[nextNode.v]) {
                        visited[nextNode.v] = true;
                        q.add(nextNode.v);
                    }
                }
            }
        }
        System.out.println(distance[endNode]);
        System.out.println(result);
    }

    static class Node {
        int v;
        int d;

        public Node (int v, int d) {
            this.v = v;
            this.d = d;
        }
    }
}