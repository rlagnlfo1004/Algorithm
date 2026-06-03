import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) que.offer(scoville[i]);
        int answer = 0;
        
        while(que.size() > 1 && que.peek() < K) {
            int a1 = que.poll();
            int a2 = que.poll();
            
            que.offer(a1 + a2 * 2);
            answer++;
        }
        return que.peek() >= K ? answer : -1;
    }
}