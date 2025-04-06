import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[][] arr = sizes;
        int w = 0;
        int h= 0;
        for(int i = 0 ; i< arr.length; i++){
            if(arr[i][0] < arr[i][1]) {
                int temp = arr[i][0];
                arr[i][0] = arr[i][1];
                arr[i][1] = temp;
            }
            w = Math.max(w, arr[i][0]);
            h = Math.max(h, arr[i][1]);
        }
        return w*h;
    }
}