import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        Map<String, Integer> map1 = new LinkedHashMap<>();
        Map<String, Integer> map2 = new LinkedHashMap<>();
        
        List<String> list =new ArrayList<>();
        for(String str : goal){
            list.add(str);
        }
        
        for(String str : cards1){
            if(list.contains(str)){
                map1.put(str, list.indexOf(str));
            }
            else{
                map1.put(str, 1000);
            }
        } 
         for(String str : cards2){
            if(list.contains(str)){
                map2.put(str, list.indexOf(str));
            }
            else{
                map2.put(str, 1000);
            }
        } 
        
        for(String key: map1.keySet()){
            System.out.println(key + ", " + map1.get(key));
        }
        int num = -1;
        for(String key : map1.keySet()){
            if(map1.get(key) < num){
                return "No";
            }
            num = map1.get(key);
        }
        
        num = -1;
        for(String key : map2.keySet()){
            if(map2.get(key) < num){
                return "No";
            }
            num = map2.get(key);
        }
        return answer;
    }
}