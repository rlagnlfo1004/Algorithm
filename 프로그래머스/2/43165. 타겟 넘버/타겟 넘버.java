import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(numbers[0]);
        q.add(-1 * numbers[0]);
        
        for(int i = 1; i < numbers.length; i++) {
            Queue<Integer> temp = new LinkedList<>();
            while(!q.isEmpty()) {
                int num = q.poll();
                temp.add(num + numbers[i]);
                temp.add(num - numbers[i]);
            }
            q = temp;
        }
        
        int answer = 0;
        while(!q.isEmpty()) {
            int num = q.poll();
            if(num == target)
                answer++;
        }
        return answer;
    }
}