import java.util.*;

class Solution {
    Deque<Character> stack = new ArrayDeque<>();
    
    boolean solution(String s) {
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}