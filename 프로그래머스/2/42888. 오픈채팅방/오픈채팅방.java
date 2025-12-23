import java.util.*;
class Solution {
    public String[] solution(String[] recor) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String[]> record = new ArrayList<>();
        for(String str : recor){
            String[] s = str.split(" ");
            if(s[0].equals("Enter")){
                map.put(s[1],s[2]);
                record.add(new String[]{s[1], s[0]});
            }
            else if(s[0].equals("Leave")){
                record.add(new String[]{s[1], s[0]});
            }
            else{
                map.put(s[1],s[2]);
            }
        }
        
        String[] answer = new String[record.size()];
        int i = 0;
        for(String[] key : record){
            if(key[1].equals("Enter"))
                answer[i++] = (map.get(key[0]) + "님이 들어왔습니다.");
            else{
                answer[i++] = (map.get(key[0]) + "님이 나갔습니다.");
            }
        }
        return answer;
    }
}