import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        Arrays.sort(strings, (s1, s2) ->{
            if(s1.charAt(n) != s2.charAt(n)){
                return Character.compare(s1.charAt(n), s2.charAt(n));
            }
            else{
                return s1.compareTo(s2);
            }
        });          
            
        return strings;
    }
}