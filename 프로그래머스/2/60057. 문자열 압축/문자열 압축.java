import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 100000;
        if(s.length() == 1) return 1;
        
        //문자열을 1~ 길이/2 만큼 잘라보기
        for(int i = 1 ; i<= s.length()/2; i++){
            StringBuilder sb = new StringBuilder();
            List<String> list =new ArrayList<>();
            int cnt = 1;
            
            // 자른 문자열을 list에 삽입
            for(int j = 0; j < s.length(); j+= i){
                if(j+i <= s.length())
                    list.add(s.substring(j, j+i));                
            }
            
            // 루프를 돌며 같은 문자열 갯수 세기
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

            // 마지막 압축 개수 붙이기
            if(cnt == 1){
                sb.append(std);
            }               
            else{
                sb.append(cnt);
                sb.append(std);
            }
            
            // n개 단위로 자르고 남은 문자열 이어붙이기
            sb.append(s.substring(s.length() - s.length()%i));
            answer = Math.min(answer, sb.length());
        }   
        return answer;
    }
}