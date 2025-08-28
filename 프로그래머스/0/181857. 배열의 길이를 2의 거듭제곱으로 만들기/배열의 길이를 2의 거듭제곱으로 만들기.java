import java.lang.*;
import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int n =(int)(Math.log10(arr.length)/Math.log10(2));
        if(Math.log10(arr.length)/Math.log10(2)%1 != 0){
            n++;
        }
        n = (int)Math.pow(2,n);
        int[] answer = new int[n];
        for(int i = 0 ; i< arr.length; i++){
            answer[i] = arr[i];
        }
        return answer;
    }
}