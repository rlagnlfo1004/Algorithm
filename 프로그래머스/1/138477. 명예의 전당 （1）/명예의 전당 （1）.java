import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        
        int[] answer = new int[score.length];
        
        PriorityQueue<Integer> scores = new PriorityQueue<>(k);
        int i = 0;
        for(int s : score) {
            scores.add(s);
            if(scores.size() > k) {
                scores.poll();
            }
            answer[i++] = scores.peek();
        }
        return answer;
    }
}