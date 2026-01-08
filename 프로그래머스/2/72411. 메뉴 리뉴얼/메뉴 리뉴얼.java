import java.util.*;
class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    boolean[] visit = new boolean[11];
    char[] chs;
    
    public String[] solution(String[] orders, int[] course) {
        for(String order : orders){
            chs = order.toCharArray();
            Arrays.sort(chs);
            String sorted = new String(chs);
            dfs(sorted,0);
            // for(String key : map.keySet()){
            //     System.out.println(key + " " + map.get(key));
            // }
            // System.out.println();
        }
        
        HashMap<Integer, Integer> aa = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        for(int c : course){
            aa.put(c, 0);
        HashMap<String, Integer> list = new HashMap<>();

            for(String key : map.keySet()){
                if(key.length() == c && map.get(key) >= 2) {
                    if(aa.get(c) <= map.get(key)) aa.put(c, map.get(key));
                    list.put(key, map.get(key));
                }
            } 
                    // System.out.println(aa.get(c));  
        
            for(String key : list.keySet()){
                if(aa.get(c) == list.get(key)) {
                    // System.out.println(aa.get(c));  
                    ans.add(key);
                }
            } 
        }
            // for(String key : list.keySet()){
            //     System.out.println(key + " ," + list.get(key));
            // } 
        
        ans.sort((o1, o2)-> o1.compareTo(o2));
        String[] answer = new String[ans.size()];
        int idx = 0;
        for(String n : ans){
            answer[idx++] = n;
        }
        
        
        
        return answer;
    }
    
    void dfs(String str, int idx){
        if(sb.length() != 0)
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
        
        
        for(int i = idx ; i < chs.length; i++){
            if(!visit[i]){
                visit[i] = true;
                sb.append(chs[i]);
                dfs(sb.toString(), i+1);
                visit[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}