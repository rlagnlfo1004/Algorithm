/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14426                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14426                          #+#        #+#      #+#    */
/*   Solved: 2025/05/07 00:15:20 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    static class Trie {
        char alphabet;
        HashMap<Character, Trie> children = new HashMap<>();

        public Trie(char alphabet) {
            this.alphabet = alphabet;
        }

        public Trie() {}
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Trie head = new Trie();

        for(int i = 0; i < N; i++) {
            Trie nextTrie = head;
            String word = br.readLine();

            for(int j = 0; j < word.length(); j++) {
                char alphabet = word.charAt(j);
                if(!nextTrie.children.containsKey(alphabet)) {
                    nextTrie.children.put(alphabet, new Trie(alphabet));
                }

                nextTrie = nextTrie.children.get(alphabet);
            }
        }

        int count = 0;
        for(int i = 0; i < M; i++) {
            Trie nextTrie = head;
            String word = br.readLine();

            for(int j = 0; j < word.length(); j++) {
                char alphabet = word.charAt(j);
                if(!nextTrie.children.containsKey(alphabet)) {
                    break;
                }
                nextTrie = nextTrie.children.get(alphabet);
                if(j == word.length() - 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}