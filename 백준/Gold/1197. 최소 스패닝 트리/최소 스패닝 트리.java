/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1197                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1197                           #+#        #+#      #+#    */
/*   Solved: 2026/01/20 16:10:45 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        int count = 0;
        int value = 0;
        while(count < V - 1) {
            Edge edge = edges.poll();
            if(union(edge.s, edge.e)) {
                value += edge.w;
                count++;
            }
        }

        System.out.println(value);
    }

    static int find(int a) {
        if(parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA != parentB) {
            parent[parentB] = parentA;
            return true;
        }
        return false;
    }

    static class Edge implements Comparable<Edge> {
        int s, e, w;
        public Edge (int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }
}