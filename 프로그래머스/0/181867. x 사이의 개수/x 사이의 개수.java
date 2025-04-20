import java.util.*;
class Solution {
    public int[] solution(String myString) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        
        int cnt = 0;
        for(char c : myString.toCharArray()){
            if(c == 'x'){
                arr.add(cnt);
                cnt = 0;
            }
            else
                cnt++;
        }
        arr.add(cnt);
        
        int len = arr.size();
        answer = new int[len];
        for(int i = 0 ; i< len ; i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}