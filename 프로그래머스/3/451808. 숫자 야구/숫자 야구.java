import java.util.*;
import java.util.function.Function;

class Solution {
    public int solution(int n, Function<Integer, String> submit) {
        
        List<Integer> A = generateAll();
        
        while(A.size() != 1) {
            int p = A.get(0);
            String result = submit.apply(p);
            
            if(result.equals("4S 0B")) return p;
            
            List<Integer> temp = new ArrayList<>();
            for(int q : A) {
                if(test(p, q).equals(result)) temp.add(q);
            }
            A = temp;
        }
        return A.get(0);
    }
    
    List<Integer> generateAll() {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            for(int j = 1; j < 10; j++) {
                if(i == j) continue;
                for(int k = 1; k < 10; k++) {
                    if(i == k || j == k) continue;
                    for(int l = 1; l < 10; l++) {
                        if(i == l || j == l || k == l) continue;
                        list.add(i * 1000 + j * 100 + k * 10 + l);
                    }
                }
            }
        }
        return list;
    }
    
    String test(int p, int q) {
        int[] P = toArray(p);
        int[] Q = toArray(q);
        int s = 0, b = 0;
        
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(P[i] == Q[j]) {
                    if(i == j) s++;
                    else b++;
                }
            }
        }
        return s + "S " + b + "B";
    }
    
    int[] toArray(int num) {
        return new int[] {num / 1000, (num / 100) % 10, (num / 10) % 10, num % 10};
    }
}