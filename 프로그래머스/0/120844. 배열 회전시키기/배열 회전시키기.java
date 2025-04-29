import java.util.*;
class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        for(int n: numbers){
            arr.add(n);
        }
        
        if(direction.equals("right")){
            arr.add(0,arr.get(arr.size()-1));
            arr.remove(arr.size()-1);   
        }else{
            arr.add(arr.size(), arr.get(0));
            arr.remove(0);
        }
        
        answer = new int[arr.size()];
        for(int i = 0 ; i< arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}