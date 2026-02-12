import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        long[] A = new long[bans.length];
        for(int i = 0; i < bans.length; i++)
            A[i] = countLength(bans[i]);
        
        Arrays.sort(A);
        for(long i : A)
            if(i <= n)
                n++;
        
        String answer = getResult(n);
        return answer;
    }
    
    static long countLength(String str) {
        long num = 0;
        long temp = 1;
        for(int i = str.length() - 1; i >= 0; i--) {
            num += (str.charAt(i) - 'a' + 1) * temp;
            temp *= 26;
        }
        return num;
    }
               
    static String getResult(long num) {
        String str = "";
        
        while (num > 0) {
            num -= 1;
            str = (char) ((num % 26) + 'a') + str;
            num /= 26;
        }
        return str;
    }
}