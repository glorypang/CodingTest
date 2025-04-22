import java.util.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] arr1 = Arrays.copyOfRange(num_list, 0 , n);
        int[] arr2 = Arrays.copyOfRange(num_list, n , num_list.length);
        
        int[] answer = new int[arr2.length+arr1.length];
        System.arraycopy(arr2, 0, answer, 0, arr2.length);
        System.arraycopy(arr1, 0, answer, arr2.length, arr1.length);
        
        
        return answer;
    }
}