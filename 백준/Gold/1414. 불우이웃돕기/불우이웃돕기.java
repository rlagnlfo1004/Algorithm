/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1414                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1414                           #+#        #+#      #+#    */
/*   Solved: 2026/01/21 17:06:25 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {

    static PriorityQueue<Edge> A;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int total = 0;
        A = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String row = sc.nextLine();

            for (int j = 0; j < N; j++) {
                if(row.charAt(j) != '0') {
                    int w = 0;
                    if(row.charAt(j) >= 'A' && row.charAt(j) <= 'Z') {
                        w = row.charAt(j) - 'A' + 27;
                    } else if(row.charAt(j) >= 'a' && row.charAt(j) <= 'z') {
                        w = row.charAt(j) - 'a' + 1;
                    }

                    A.add(new Edge(i, j, w));
                    total += w;
                }
            }
        }

        int count = 0;
        while(!A.isEmpty()) {
            Edge now = A.poll();
            if(union(now.s, now.e)) {
                count++;
                total -= now.w;
            }
            if(count == N - 1) {
                break;
            }
        }

        if(count == N - 1) {
            System.out.println(total);
        } else {
            System.out.println(-1);
        }
    }

    static int find(int a) {
        if(parent[a] == a) return a;
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
        public Edge(int s, int e, int w) {
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