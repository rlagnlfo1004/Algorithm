import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Task> queue = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++) {
            queue.add(new Task(i, priorities[i]));
        }
        
        Arrays.sort(priorities);
        
        int answer = 0;
        while(!queue.isEmpty()) {
            while(queue.peek().priority != priorities[priorities.length - answer - 1]) {
                queue.add(queue.poll());
            }
            
            Task task = queue.poll();
            answer++;
            if(task.index == location) {
                return answer;
            }
        }
        return 0;
    }
    
    class Task {
        int index;
        int priority;
        
        public Task (int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}