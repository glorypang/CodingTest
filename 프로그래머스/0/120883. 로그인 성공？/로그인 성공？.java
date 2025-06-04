import java.util.*;
class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        Map<String, String> map = new HashMap<>();
        for(String[] d : db){
            map.put(d[0], d[1]);
        }
        
        if(!map.containsKey(id_pw[0])){
            return "fail";
        }
        else{
            if(id_pw[1].equals(map.get(id_pw[0]))){
                return "login";
            }
            else{
                return "wrong pw";
            }
        }
    }
}