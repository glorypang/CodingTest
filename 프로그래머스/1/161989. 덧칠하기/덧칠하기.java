import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        Arrays.sort(section);
        
        for(int i = 0 ; i< section.length; i++){
            for(int j = i+1 ; j < section.length; j++){
                
                if(section[j] -section[i] +1 > m){
                    //System.out.println(i + ", " + j);
                    answer++;
                    
                    i =j-1;
                    break;
                }
            }
        }
        
        return answer+1;
    }
}