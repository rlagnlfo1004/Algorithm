import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int total = set.size();
        
        HashMap<String, Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int bestLeft = 0;
        int bestRight = gems.length - 1;
        
        while(right < gems.length) {
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            
            while(map.size() == total) {
                int temp = right - left;
                if(right - left < bestRight - bestLeft) {
                    bestLeft = left;
                    bestRight = right;
                }
                
                map.put(gems[left], map.get(gems[left]) - 1);
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            }
            right++;
        }
        
        int[] answer = {bestLeft + 1, bestRight + 1};
        return answer;
    }
}