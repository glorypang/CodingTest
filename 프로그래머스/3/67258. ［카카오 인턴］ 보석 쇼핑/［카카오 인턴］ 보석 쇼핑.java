import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 보석 종류
        Set<String> s = new HashSet<>();
        for(String g : gems)
            s.add(g);
        
        HashMap<String, Integer> map = new HashMap<>();
        int left = 1000011;
        int right = 1000011;
        int len = 1000011;
        int temp_l = 0;
        int temp_r = 0;
        for(String g : gems){
            if(map.size() < s.size()){
                map.put(g, map.getOrDefault(g, 0)+1);
                temp_r++;
            }
            while(map.size() == s.size()){
                String str = "";
                if(temp_l < temp_r){
                    str = gems[temp_l];
                    temp_l++;
                }
                map.put(str, map.getOrDefault(str, 0)-1);
                if(map.get(str) <= 0){
                    map.remove(str);
                }
                if(map.size() < s.size()){
                    if(len > temp_r - temp_l){
                        left = temp_l;
                        right = temp_r;
                        len = temp_r - temp_l;
                    }      
                }
            }
            // System.out.println(g + " " + temp_l + " " + temp_r);
        }
        
        int[] answer = new int[]{left, right};
        return answer;
    }
}