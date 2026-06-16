import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        List<Set<Integer>> dp = new ArrayList<>();
        for(int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        for(int i = 1; i <= 8; i++) {
            dp.get(i).add(initNum(N, i));
            
            for(int left = 1; left < i; left++) {
                int right = i - left;
                
                for(int r : dp.get(right)) {
                    for(int l : dp.get(left)) {
                        dp.get(i).add(r + l);
                        dp.get(i).add(r - l);
                        dp.get(i).add(r * l);
                        if(l != 0) dp.get(i).add(r / l);
                    }
                }
            }
            
            if(dp.get(i).contains(number)) {
                return i;
            }
        }        
        return -1;
    }
    
    int initNum(int N, int count) {
        int result = N;
        for(int i = 1; i < count; i++) {
            result = result * 10 + N;
        }
        return result;
    }
}