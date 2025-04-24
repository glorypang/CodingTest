import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] arr1 = Arrays.copyOfRange(arr,intervals[0][0],intervals[0][1]+1);
        int[] arr2 = Arrays.copyOfRange(arr,intervals[1][0],intervals[1][1]+1);
        int[] answer = new int[arr1.length+arr2.length];
        System.arraycopy(arr1, 0, answer, 0 ,arr1.length);
        System.arraycopy(arr2, 0, answer, arr1.length ,arr2.length);
        
        
        return answer;
    }
}