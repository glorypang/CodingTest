import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0 ; i< rank.length; i++){
            if(attendance[i]){
                map.put(rank[i], i);
            }
        }
        
        int[] list = new int[3];
        int idx = 0;
        for(int key : map.keySet()){
            if(idx == 3) break;
            list[idx++] = map.get(key);
        }
        int a = list[0];
        int b = list[1];
        int c = list[2];
        
        return 10000*a+100*b+c;
    }
}