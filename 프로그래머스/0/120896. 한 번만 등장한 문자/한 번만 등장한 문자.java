import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        List<Stack<Integer>> list = new ArrayList<>();
        for(int i =0  ; i < 26; i++){
            list.add(new Stack<>());
        }
        for(char c : s.toCharArray()){
            int num = c - 'a';
            list.get(num).push(1);
        }
        for(int i = 0 ; i < 26 ; i++){
            int size = list.get(i).size();
            if(size == 1){
                sb.append((char)(i+'a'));
            }
        }
        
        
        return sb.toString();
    }
}