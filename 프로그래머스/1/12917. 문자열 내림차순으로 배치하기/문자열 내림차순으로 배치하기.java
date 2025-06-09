import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
		List<Character> list =new ArrayList<>();
        for(char c : s.toCharArray()){
            list.add(c);
        }
        
        Collections.sort(list, Collections.reverseOrder());
    
		StringBuilder sb = new StringBuilder();
        for(char c: list){
            sb.append(c);
        }
        return sb.toString();
    }
}