import java.util.*;
class Solution {
    public int[] solution(int n, int[] numlist) {
        List<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < numlist.length ; i++){
            if(numlist[i]%n ==0)
                arr.add(numlist[i]);
        }
        int[] answer = new int[arr.size()];
        for(int i = 0 ; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}