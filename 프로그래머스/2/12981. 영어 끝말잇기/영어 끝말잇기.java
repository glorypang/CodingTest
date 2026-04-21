import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        List<String> word = new ArrayList<>();

        
        String before ="";
        for(int i = 0 ; i <words.length; i++){
            if(word.contains(words[i]) || (i>0 && before.charAt(before.length()-1) != words[i].charAt(0))){
                return new int[]{i%n+1, i/n+1};
            }
            else
                word.add(words[i]);
            
            before = words[i];
            
        }
        return new int[]{0, 0};
    }
}