import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        // 1 3 5 7
        // 2 2 6 8
        
        int idx =0;
        for(int i = 0; i < B.length; i++){
            if(idx >= B.length) break;
            if(A[i] < B[idx]) {
                answer++;
                idx++;
            }else{
                while(idx < B.length){ // 
                    if(A[i] < B[idx]) { //
                        answer++;
                        idx++;        
                        break;
                    }
                    idx++;
                }
            }
        }
        return answer;
    }
}