import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int cnt = 0;
        for(String s : operations){
            String[] str = s.split(" ");
            
            if(str[0].equals("I")){
                tm.put(Integer.parseInt(str[1]), tm.getOrDefault(Integer.parseInt(str[1]),0)+1);
                cnt++;
            }
            else if(tm.size() >= 1 && str[0].equals("D")){
                cnt--;
                if(str[1].equals("1")){
                    tm.put(tm.lastKey(), tm.get(tm.lastKey())-1);
                    if(tm.get(tm.lastKey()) <= 0){
                        tm.remove(tm.lastKey());
                    }
                }
                else{
                    tm.put(tm.firstKey(), tm.get(tm.firstKey())-1);
                    if(tm.get(tm.firstKey()) <= 0){
                        tm.remove(tm.firstKey());
                    }
                }
            }
        }
        
        if(cnt <= 0){
            return new int[]{0, 0};
        }
        else{
            return new int[]{tm.lastKey(), tm.firstKey()};
        }
    }
}