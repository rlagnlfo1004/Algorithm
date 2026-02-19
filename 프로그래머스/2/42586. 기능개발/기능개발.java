import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i< progresses.length; i++) {
            int com = 0;
            int k = 1;
            while(100 > com) {
                com = speeds[i] * k + progresses[i];
                k++;
            }
            queue.add(k - 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            int now = queue.poll();
            int count = 1;
            while(!queue.isEmpty()) {
                if(queue.peek() <= now) {
                    count++;
                    queue.poll();
                } else {
                    break;
                }
            }
            list.add(count);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}