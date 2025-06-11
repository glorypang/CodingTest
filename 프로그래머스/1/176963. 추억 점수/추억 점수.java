import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i< name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        int idx = 0;
        for(String[] ph : photo){
            int sum = 0;
            for(String p : ph){
                if(map.containsKey(p))
                    sum += map.get(p);
            }
            answer[idx++] = sum;
        }
        return answer;
    }
}