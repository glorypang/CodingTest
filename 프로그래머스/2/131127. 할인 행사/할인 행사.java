import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        for(int i = 0 ; i <want.length; i++){
            map2.put(want[i], number[i]);
        }
        
        for(int i = 0 ; i < 10; i++){
            map.put(discount[i], map.getOrDefault(discount[i], 0)+1);
        }
        
        boolean check = true;
        for(String key : map2.keySet()){
            if(map.get(key) != map2.get(key)){
                check = false;
                break;
            }
        }
        
        if(check) answer++;;
    
        for(int i = 1 ; i< discount.length-9; i++){
            map.put(discount[i+9], map.getOrDefault(discount[i+9], 0)+1);
            map.put(discount[i-1], map.get(discount[i-1])-1);
            
            check = true;
            for(String key : map2.keySet()){
                if(map.get(key) != map2.get(key)){
                    check = false;
                    break;
                }
            }
            if(check) answer++;
        }                        
        return answer;
    }
}