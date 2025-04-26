import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> arr = new ArrayList<>();
        arr.add(n);
        while(n != 1){
            if(n%2 == 0) n /=2;
            else n = 3*n + 1;
            arr.add(n);
        }
        
        int len = arr.size();
        int[] answer = new int[len];
        for(int i = 0 ; i < len ; i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}