import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Set<String> reportSet = new HashSet<>();
        for(String s: report){
            reportSet.add(s);
        }
        
        Map<String, Integer> rc = new HashMap<>();
        Map<String, List<String>> r = new HashMap<>();
        for(String s : reportSet){
            String[] part = s.split(" ");
            String from = part[0];
            String to = part[1];
            
            rc.put(to, rc.getOrDefault(to, 0)+1);
            if(!r.containsKey(from)){
                r.put(from, new ArrayList<>());
            }
            r.get(from).add(to);
        }
        for(int i = 0 ; i < id_list.length; i++){
            String reporter = id_list[i];
            for(String rt : r.getOrDefault(reporter, new ArrayList<>())){
                if(rc.get(rt) >= k){
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}