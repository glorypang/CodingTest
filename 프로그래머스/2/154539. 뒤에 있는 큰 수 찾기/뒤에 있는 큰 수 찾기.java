import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0 ; i< numbers.length; i++){
            while(!s.isEmpty() && numbers[s.peek()] < numbers[i]){
                answer[s.pop()] = numbers[i];
            }
            s.push(i);
        }
        
        while(!s.isEmpty()){
            answer[s.pop()] = -1;
        }
        
        return answer;
    }
}