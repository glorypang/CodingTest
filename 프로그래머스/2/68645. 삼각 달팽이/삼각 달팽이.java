import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        int total = 0 ;
        for(int i = 1 ; i <n ; i++)
            total += i;
        
        int cnt = 0;
        int cycle = 1;
        int std = 1;
        while(std <= total+n){
            int len = n - cycle -(2*(cycle-1)); // len 6 3 0
            for(int i = 0 ; i <= len; i++){  
                map[(cycle-1)*2+i][cycle-1] = std++;
            }
            for(int i = 0 ; i < len; i++){  //
                map[n-cycle][cycle+i] = std++;
            }
            for(int i = 0 ; i<  len-1 ; i++){
                map[n-cycle-i-1][n-cycle-i-(cycle-1)-1] = std++;
            }
            cycle++;
            
            
            
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
                for(int j=0 ; j < n ; j++){
                    if(map[i][j] > 0)
                        list.add(map[i][j]);    
                }
            }
        
        int len = list.size();
        int[] answer = new int[len];
        int idx =0;
        for(int num : list){
            answer[idx++] = num;
        }
        return answer;
    }
}