import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : array){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        int maxCnt = 0;
        int max = 0;
        int cnt = 0;
 
        //1 : 2 / 2 : 2
        for(int key : map.keySet()){
            if(map.get(key) > cnt){
                max = key; // 1
                maxCnt = 0;
                cnt = map.get(key); // 2
            }
            else if(map.get(key) == cnt){
                maxCnt++;
            }
        }
        
        if(maxCnt > 0)
            return -1;
        else{
            return max;
                        
        }
    }
}