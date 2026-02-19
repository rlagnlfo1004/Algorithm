import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : arr) {
            if(set.contains(num)) continue;
            set = new HashSet<>();
            set.add(num);
            list.add(num);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}