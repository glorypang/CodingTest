import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i< numlist.length; i++){
            map.put(numlist[i], Math.abs(numlist[i] - n));
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        
        keySet.sort(new Comparator<Integer>(){
            public int compare(Integer o1,  Integer o2){
                int diff = map.get(o1).compareTo(map.get(o2));
                if(diff == 0)
                    return o2 - o1;
                else
                    return diff;
            }
        });
              
        int idx = 0;
        for(int key : keySet){
            answer[idx++] = key;
        }
        return answer;
    }
}