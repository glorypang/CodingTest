
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        float[] asd = new float[N];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i< stages.length ; i++){
            map.put(stages[i], map.getOrDefault(stages[i], 0)+1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
            
        int sum = stages.length;
        for(int i = 1; i<= N; i++){
            if(map.containsKey(i)){
                asd[i-1] = (float)map.get(i)/sum;
                sum -= map.get(i);
            }
            else{
                asd[i-1] = 0;
            }
        }
        
        Map<Integer, Float> map2 = new HashMap<>();
        for(int i = 1 ; i<= N ; i++){
            map2.put(i, asd[i-1]);
        }
        
        List<Map.Entry<Integer, Float>> entryList = new ArrayList<>(map2.entrySet());
        
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        int idx =0;
        for(Map.Entry<Integer, Float> entry : entryList){
            answer[idx++] =entry.getKey();
        }
        return answer;
    }
}