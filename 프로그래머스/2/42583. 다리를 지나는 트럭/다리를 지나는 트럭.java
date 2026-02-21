import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++) {
            q.add(0);
        }
        
        int answer = 0;
        int nowWeight = 0;
        int count = 0;
        
        while(!q.isEmpty()) {
            answer++;
            nowWeight -= q.poll();
            if(truck_weights[count] <= weight - nowWeight) { // 삽입 가능
                q.add(truck_weights[count]);
                nowWeight += truck_weights[count];
                count++;
            } else { // 삽입 불가능 : 0 삽입
                q.add(0);
            }
            
            if(count == truck_weights.length) {
                answer += bridge_length;
                break;
            }
        }
        return answer;
    }
}