import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 100000;
        if(s.length() == 1) return 1;
        for(int i = 1 ; i<= s.length()/2; i++){
            StringBuilder sb = new StringBuilder();
            List<String> list =new ArrayList<>();
            int cnt = 1;
            for(int j = 0; j < s.length(); j+= i){
                if(j+i <= s.length())
                    list.add(s.substring(j, j+i));                
            }
            
            // for(String sa :list){
            //     System.out.println(sa);
            // }
            String std = list.get(0); 
            for(int j = 1 ; j < list.size(); j++){
                if(list.get(j).equals(std)) {
                    cnt++;
                }
                else{
                    if(cnt == 1){
                        sb.append(std);
                    }               
                    else{
                        sb.append(cnt);
                        sb.append(std);
                    }
                    std = list.get(j);
                    cnt = 1;
                }
            }
            if(cnt == 1){
                sb.append(std);
            }               
            else{
                sb.append(cnt);
                sb.append(std);
            }
            
            sb.append(s.substring(s.length() - s.length()%i));
            // System.out.println(sb);
            answer = Math.min(answer, sb.length());
        }   
        return answer;
    }
}