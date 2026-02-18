// import java.util.*;

// class Solution {
//     public boolean solution(String[] phone_book) {
//         HashSet<String> set = new HashSet<>();
//         for(String str : phone_book)
//             set.add(str);
        
//         for(int i = 0; i < phone_book.length; i++) {
//             for(int j = 1; j < phone_book[i].length(); j++) {
//                 if(set.contains(phone_book[i].substring(0, j)))
//                     return false;
//             }
//         }
        
//         return true;
//     }
// }

import java.util.Arrays;

class Solution {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);

        for (int i = 0; i < phoneBook.length - 1; i++)
            if (phoneBook[i + 1].startsWith(phoneBook[i]))
                return false;
        
        return true;
    }
}
