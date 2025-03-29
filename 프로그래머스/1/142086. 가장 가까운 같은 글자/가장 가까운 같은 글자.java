import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer, -1);
        
        for(int i = s.length()-1 ; i >= 0 ; i--){ // 5 4 3 2 1 0
            char charI = s.charAt(i);
            for(int j = 0 ; j<i; j++){ // 0 1 2 3 4
                char charJ = s.charAt(j);
                if(charI == charJ) answer[i] = i-j;
            }
        }
            
        return answer;
    }
}