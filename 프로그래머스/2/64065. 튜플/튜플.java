import java.util.*;
class Solution {
    public int[] solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        s = s.replaceAll("[{}]", "");
        String[] str = s.split(",");
        
        for(int i = 0 ; i < str.length; i++){
            map.put(str[i], map.getOrDefault(str[i], 0)+1);
        }
        
        ArrayList<String> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2)-> map.get(o2).compareTo(map.get(o1)));
        
        
        
        List<String> ans = new ArrayList<>();
        for(String key : list){
            ans.add(key);
        }
        
        int len = ans.size();
        int[] answer= new int[len];
        for(int i = 0 ; i < len; i++){
            answer[i] = Integer.parseInt(ans.get(i));
        }
        return answer;
    }
}