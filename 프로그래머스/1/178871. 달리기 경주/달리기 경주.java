import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> map = new HashMap<>();
        
        // 선수 리스트와 이름 → 인덱스 맵핑
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String call : callings) {
            int idx = map.get(call);
            
            // 바로 앞 선수와 swap
            if (idx > 0) {
                String prevPlayer = players[idx - 1];
                
                // swap
                players[idx - 1] = call;
                players[idx] = prevPlayer;
                
                // map 업데이트
                map.put(call, idx - 1);
                map.put(prevPlayer, idx);
            }
        }
        
        return players;
    }
}