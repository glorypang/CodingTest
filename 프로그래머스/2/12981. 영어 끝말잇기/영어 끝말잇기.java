import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        int cnt = 1;
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for(int i =1; i < words.length; i++){
            if(list.contains(words[i])) {
                //System.out.println("fail conitans: " + words[i]);

                break;
            }
            String listStr = list.get(list.size()-1);
            if(listStr.charAt(listStr.length()-1) != words[i].charAt(0)) {
                            //System.out.println("fail lead: " + words[i]);

                break;
            
            }
            list.add(words[i]);
            //System.out.println("Insert Str: " + words[i]);
            cnt++;
        }
        if(cnt == words.length) return new int[]{0,0};
        cnt++;
        return new int[]{cnt%n==0 ? n : cnt%n, cnt%n==0 ?  cnt/n: cnt/n+1};
    }
}