import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(String str : operations){
            String[] s = str.split(" ");
            int num = Integer.parseInt(s[1]);
            if(s[0].equals("I")){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            else if(!map.isEmpty()){
                int key = (num == 1) ? map.lastKey() : map.firstKey(); // ✅ 수정된 부분
                if(map.get(key) == 1){
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
            }
        }

        if(map.isEmpty()) return new int[]{0, 0};
        return new int[]{map.lastKey(), map.firstKey()};
    }
}
