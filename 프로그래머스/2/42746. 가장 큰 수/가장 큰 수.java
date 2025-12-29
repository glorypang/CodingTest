import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> list = new ArrayList<>();
        for(int n : numbers){
            list.add(n+"");
        }
        
        Collections.sort(list, (o1, o2)-> {
            return (o2+o1).compareTo(o1+o2);
        });
        
        if(list.get(0).equals("0")) return "0";
        
        for(String n : list){
            answer+=n;
        }
        return answer;
    }
}