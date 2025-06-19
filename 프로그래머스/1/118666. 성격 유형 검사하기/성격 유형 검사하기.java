import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ;i < survey.length; i++){
            if(choices[i] < 4){
                map.put(survey[i].charAt(0), map.getOrDefault(survey[i].charAt(0), 0)+3-choices[i]+1);
            }
            else if(choices[i] > 4){
                map.put(survey[i].charAt(1), map.getOrDefault(survey[i].charAt(1), 0)+choices[i]-4);
            }
        }
        
        int R = map.getOrDefault('R', 0);
        int T = map.getOrDefault('T', 0);
        int C = map.getOrDefault('C', 0);
        int F = map.getOrDefault('F', 0);
        int J = map.getOrDefault('J', 0);
        int M = map.getOrDefault('M', 0);
        int A = map.getOrDefault('A', 0);
        int N = map.getOrDefault('N', 0);
        
        sb.append(R >= T ? 'R' : 'T');
        sb.append(C >= F ? 'C' : 'F');
        sb.append(J >= M ? 'J' : 'M');
        sb.append(A >= N ? 'A' : 'N');
        return sb.toString();
    }
}