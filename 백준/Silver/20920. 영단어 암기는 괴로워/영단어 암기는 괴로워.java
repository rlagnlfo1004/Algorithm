/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 20920                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/20920                          #+#        #+#      #+#    */
/*   Solved: 2025/03/30 19:55:17 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        while( N-- > 0 ){

            String word = br.readLine();
            if( word.length() >= M ){

                if(map.containsKey(word))
                    map.replace(word, map.get(word)+1);
                else
                    map.put(word,1);

            }
        }
        Node[] arr = new Node[map.size()];
        int index = 0;
        for( Map.Entry<String, Integer> entry : map.entrySet() )
            arr[index++] = new Node(entry.getKey(), entry.getValue());
            
		// 기준에 따른 정렬
        Arrays.sort(arr, (a,b)->{
            if( a.numOfAppear != b.numOfAppear )
                return Integer.compare( b.numOfAppear, a.numOfAppear);
            else if( a.word.length() != b.word.length())
                return Integer.compare( b.word.length(), a.word.length());
            else
                return a.word.compareTo(b.word);
        });

        Arrays.stream(arr).forEach( node ->  sb.append(node.word).append("\n"));
        System.out.println(sb);
    }
    static class Node{
        String word;
        int numOfAppear;
        Node(String word, int numOfAppear){
            this.word = word;
            this.numOfAppear = numOfAppear;
        }
    }
}