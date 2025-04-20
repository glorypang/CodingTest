import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        for(char c : my_string.toCharArray()){
            if(Character.isDigit(c)){
                arr.add(c-'0');
            }
        }
        answer = new int[arr.size()];
        for(int i = 0 ; i < arr.size() ; i++){
            answer[i] = arr.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}