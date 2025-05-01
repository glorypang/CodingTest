import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        System.out.println(Math.sqrt(arr.length));
        ArrayList<Integer> list = new ArrayList<>();
        for(int n  : arr)
            list.add(n);
        
        while(!powerOfTwo(list.size())){
            list.add(0);    
        }
        int len = list.size();
        answer = new int[len];
        for(int i =0  ; i< len ; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    public boolean powerOfTwo(long num) {
    while(num > 2){	
        if(num % 2 == 1) 
            return false;	
        num /= 2;			
    }
    return true;
}
}