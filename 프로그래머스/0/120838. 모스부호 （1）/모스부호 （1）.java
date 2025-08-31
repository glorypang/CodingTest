import java.util.*;
class Solution {
    public String solution(String letter) {
        String answer = "";
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        String[] letters = letter.split(" ");
        for(String let : letters){
            int idx = Arrays.asList(morse).indexOf(let);
            answer += (char)(idx+'a')+"";
        }
        
        return answer;
    }
}