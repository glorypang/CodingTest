import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        for(String str : phone_book){
            set.add(str);
        }
        
        for(int i = 0 ; i < phone_book.length; i++){
            String number = phone_book[i];
            String prefix = "";
            
            for(int j = 0 ; j <  number.length()-1; j++){
                prefix += number.charAt(j);
                
                if(set.contains(prefix)){
                    return false;
                }
            }
        }
        
        return true;
    }
}