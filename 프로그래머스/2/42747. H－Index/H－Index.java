import java.util.*;

class Solution {
    public int solution(int[] citations) { 
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations); 
    
        for(int h = 0 ; h < citations[n-1] ; h++){ // 1 1 3 3
           int cnt = 0; // h 번 이상 인용된 논문 수
            for(int j = 0; j < n; j++){
               if(citations[j] >= h) cnt++;
            }
            if (cnt >= h){ // h 번 이상 인용된 논문이 h편 이상 
                if(n-cnt <= h){ // 나머지 논문이 h번 이하 인용
                    answer = h;
                }
            }
        }
        return answer;
    }
}