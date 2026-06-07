import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 1;
        long right = (long) times[times.length - 1] * n;
        
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            
            long cnt = 0;
            for(int t : times) {
                cnt += mid / t;
                if(cnt >= n) break;
            }
            
            if(cnt < n) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        
        return answer;
    }
}