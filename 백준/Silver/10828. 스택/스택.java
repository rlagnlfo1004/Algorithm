/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10828                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: hrkim2001 <boj.kr/u/hrkim2001>              +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10828                          #+#        #+#      #+#    */
/*   Solved: 2025/06/01 21:35:32 by hrkim2001     ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        // 직접 구현한 배열 기반 스택 사용
        CustomStack stk = new CustomStack(N);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    stk.push(x);
                    break;

                case "pop":
                    sb.append(stk.pop()).append('\n');
                    break;

                case "size":
                    sb.append(stk.size()).append('\n');
                    break;

                case "empty":
                    sb.append(stk.empty()).append('\n');
                    break;

                case "top":
                    sb.append(stk.top()).append('\n');
                    break;
            }
        }

        // 한 번에 출력
        System.out.print(sb.toString());
        br.close();
    }
}

// 배열 기반 스택을 직접 구현한 클래스
class CustomStack {
    private int[] arr;
    private int topIndex; // 현재 가장 위 원소의 인덱스 (0부터 시작)

    public CustomStack(int capacity) {
        arr = new int[capacity];
        topIndex = -1; // 비어 있을 때
    }

    public void push(int x) {
        arr[++topIndex] = x;
    }

    public int pop() {
        if (topIndex < 0) {
            return -1;
        }
        return arr[topIndex--];
    }

    public int size() {
        return topIndex + 1;
    }

    public int empty() {
        return (topIndex < 0) ? 1 : 0;
    }

    public int top() {
        if (topIndex < 0) {
            return -1;
        }
        return arr[topIndex];
    }
}
