/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2910                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2910                           #+#        #+#      #+#    */
/*   Solved: 2025/05/07 23:43:12 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> firstIndex = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!firstIndex.containsKey(num)) {
                firstIndex.put(num, i);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> {
            if (Objects.equals(map.get(o1), map.get(o2))) {
                return firstIndex.get(o1) - firstIndex.get(o2);
            }
            return map.get(o2).compareTo(map.get(o1));
        });

        for (int num : list) {
            for (int i = 0; i < map.get(num); i++) {
                bw.write(num + " ");
            }
        }
        bw.flush();
    }
}