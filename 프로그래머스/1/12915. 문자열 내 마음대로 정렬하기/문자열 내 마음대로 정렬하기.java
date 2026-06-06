import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, (o1, o2) -> {
            if (o1.charAt(n) == o2.charAt(n)) return compare(o1, o2);
            return o1.charAt(n) - o2.charAt(n);
        });
            
        return strings;
    }
    
    int compare(String str1, String str2) {
        for(int i = 0; i < str1.length(); i++) {
            int diff = str1.charAt(i) - str2.charAt(i);
            if(diff != 0) return diff;
        }
        return 0;
    }
}