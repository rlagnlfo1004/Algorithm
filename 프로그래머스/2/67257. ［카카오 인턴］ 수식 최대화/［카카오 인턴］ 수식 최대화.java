import java.util.*;

class Solution {
    
    String[] priority = new String[]{"+*-", "+-*", "*-+", "*+-", "-+*", "-*+"};
    List<Long> numbers = new ArrayList<>();
    List<Character> operators = new ArrayList<>();
    
    public long solution(String expression) {
        
        StringBuilder num = new StringBuilder();
        
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            if(ch == '+' || ch == '-' || ch == '*') {
                numbers.add(Long.parseLong(num.toString()));
                num.setLength(0);
                operators.add(ch);
            } else {
                num.append(ch);
            }
        }
        numbers.add(Long.parseLong(num.toString()));
        
        long answer = 0;
        for(int i = 0; i < 6; i++) {
            answer = Math.max(answer, cal(priority[i]));
        }
        return answer;
    }
    
    long cal(String pri) {
        List<Long> tempNums = new ArrayList<>(numbers);
        List<Character> tempOpers = new ArrayList<>(operators);
        
        for(int i = 0; i < 3; i++) {
            char p = pri.charAt(i);
            
            for(int j = 0; j < tempOpers.size(); ) {
                if(tempOpers.get(j) == p) {
                    long temp = operate(p, tempNums.get(j), tempNums.get(j + 1));
                    
                    tempNums.set(j, temp);
                    tempNums.remove(j + 1);
                    tempOpers.remove(j);
                } else {
                    j++;
                }
            }
        }
        return Math.abs(tempNums.get(0));
    }
    
    long operate(char op, long left, long right) {
        if(op == '-') return left - right;
        else if (op == '+') return left + right;
        else return left * right;
    }
}