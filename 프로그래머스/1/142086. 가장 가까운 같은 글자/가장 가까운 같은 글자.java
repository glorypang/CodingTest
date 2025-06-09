import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        int idx = 0;
        for(char c : s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, idx);
                answer[idx] = -1;
            }
            else{
                answer[idx] = idx - map.get(c);
                map.put(c, idx);

            }
            idx++;
        }
        return answer;
    }
}