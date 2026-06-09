import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (o1, o2) -> {
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        PriorityQueue<Job> Q = new PriorityQueue<>();
        
        int idx = 0;
        int cnt = 0;
        int time = 0;
        int answer = 0;
        
        while(cnt < jobs.length) {
            while(idx < jobs.length && time >= jobs[idx][0]) {
                Q.add(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if(Q.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }
            
            Job job = Q.poll();
            time += job.duration;
            answer += time - job.time;
            cnt++;
        }

        return answer / jobs.length;
    }
    
    class Job implements Comparable<Job> {
        int time;
        int duration;
        
        public Job (int t, int d) {
            time = t;
            duration = d;
        }
        
        @Override
        public int compareTo(Job j) {
            if(duration != j.duration) return duration - j.duration;
            return time - j.time;
        }
    }
}