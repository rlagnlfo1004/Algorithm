import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = 0;
        
        for(int t : times) {
            right = Math.max(right, t);
        }
        right *= n;
        
        long answer = right;
        while(left <= right) {
            long mid = (left + right) / 2;
            long count = cal(n, mid, times);
            
            if (count >= n) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;   
            }
        }
        return answer;
    }
    
    public long cal(int n, long total, int[] times) {
        long count = 0;
        for(int t : times) {
            count += total / t;
            
            if(count > n) break;
        }
        return count;
    }
    
}
