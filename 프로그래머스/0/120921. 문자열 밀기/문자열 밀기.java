import java.util.*;
class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        if(A.equals(B)) return 0;
    
        String temp = A;
        for(int i =0  ; i< A.length(); i++){
            temp = temp.charAt(temp.length()-1)  + temp.substring(0, temp.length()-1) ;
            answer++;
            
            if(temp.equals(B)){
                break;
            }
        }
        
        if(answer == A.length()){
            return -1;
        }
        return answer;
    }
}