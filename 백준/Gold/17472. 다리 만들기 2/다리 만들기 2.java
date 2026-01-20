/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17472                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17472                          #+#        #+#      #+#    */
/*   Solved: 2026/01/20 23:33:41 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static ArrayList<ArrayList<int[]>> sList;
    static int N, M, sNum = 1;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static PriorityQueue<Edge> edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        edges = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    BFS(i, j);
                }
            }
        }
        sNum--;

        // 경로 탐색
        for (int i = 0; i < sList.size(); i++) {
            ArrayList<int[]> now = sList.get(i);
            
            for (int j = 0; j < now.size(); j++) {
                int row = now.get(j)[0];
                int col = now.get(j)[1];
                int nowS = map[row][col];

                for (int k = 0; k < 4; k++) { // 4 방향으로 탐색 진행
                    int rowDir = dr[k];
                    int colDir = dc[k];
                    int len = 0;

                    while (row + rowDir >= 0 && row + rowDir < N && col + colDir >= 0 && col + colDir <M) {
                        if(map[row + rowDir][col + colDir] == nowS) {
                            break;
                        } else if(map[row + rowDir][col + colDir] != 0) {
                            if(len > 1) {
                                edges.add(new Edge(nowS, map[row + rowDir][col + colDir], len));
                            }
                            break;
                        } else {
                            len++;
                            rowDir += dr[k];
                            colDir += dc[k];
                        }
                    }
                }
            }
        }

        parent = new int[sNum + 1];
        for (int i = 1; i <= sNum; i++) {
            parent[i] = i;
        }
        
        int result = 0;
        int count = 0;
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();

            if (union(edge.s, edge.e)) {
                count++;
                result += edge.w;
            }
        }

        if(count == sNum - 1) System.out.println(result);
        else System.out.println(-1);
    }

    static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> myList = new ArrayList<>();

        int[] start = { i, j };
        q.add(start);
        visited[i][j] = true;
        map[i][j] = sNum;
        myList.add(start);

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int k = 0; k < 4; k++) {
                int row = now[0] + dr[k];
                int col = now[1] + dc[k];

                if(row >= 0 && row < N && col >= 0 && col < M)
                    if(!visited[row][col] && map[row][col] != 0) {
                        visited[row][col] = true;
                        map[row][col] = sNum;
                        int[] temp = { row, col };
                        q.add(temp);
                        myList.add(temp);
                    }

            }
        }
        sList.add(myList);
        sNum++;
    }

    static int find(int v) {
        if(parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }

    static boolean union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if(parA != parB) {
            parent[parB] = parA;
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
        public int compareTo (Edge e) {
            return this.w - e.w;
        }
    }
}