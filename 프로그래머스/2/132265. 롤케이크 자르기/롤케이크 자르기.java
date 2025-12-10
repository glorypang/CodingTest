import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        
        for(int i = 0 ; i < len ; i++){
            map2.put(topping[i], map2.getOrDefault(topping[i], 0) + 1);
        }
        for(int i = 0 ; i < len ; i++){
            map1.put(topping[i], map1.getOrDefault(topping[i], 0) + 1);
            map2.put(topping[i], map2.get(topping[i])-1);
            if(map2.get(topping[i]) == 0) map2.remove(topping[i]);
            
            // System.out.println(map1.size() + ", " + map2.size());
            // for(int key : map2.keySet()){
            // System.out.println(key + " " + map2.get(key));
            //     }
            // System.out.println();
            if(map1.size() == map2.size()) answer++;
        }
        return answer;
    }
}