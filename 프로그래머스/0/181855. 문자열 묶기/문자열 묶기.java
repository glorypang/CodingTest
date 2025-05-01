import java.util.*;
class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < strArr.length; i++){
            map.put(strArr[i].length(), map.getOrDefault(strArr[i].length(),0)+1);
        }
        
        int max = Integer.MIN_VALUE;
        for (int value : map.values()) {
            max = Math.max(max, value);
        }
        return max;
    }
}