import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        int days = Integer.parseInt(today.replaceAll("\\.", ""));
                         System.out.println(days);

        Map<String, Integer> map = new HashMap<>();
        
        for(String s : terms){
            String[] strs = s.split(" ");
            map.put(strs[0], Integer.parseInt(strs[1]));
        }
        
        int idx = 1;
        for(String s : privacies){

             String[] strs = s.split(" ");
             String[] st = strs[0].split("\\.");
             int n = map.get(strs[1]);
            
             int year = Integer.parseInt(st[0]);
             int month = Integer.parseInt(st[1]);
             int day = Integer.parseInt(st[2]);
            
            day -=1;
            if(day <= 0){
                month -= 1;
                day = 28;
            }
            
            //11월 + 13월 -> 2009년 12월 3일
            //11월 + 2월 -> 2009년 1월 3일
            //11월 + 3월 -> 2월 
            int m = month + n;
            if(m > 12){
                year +=n/12;
                month += (n)%12;
                
                if(month > 12){
                    year += month/12;
                    
                    month %= 12;
                }
            }
            else{
               month += n;

            }

            
            
            int times = year*10000+month*100+day;
                 //System.out.println(times);

            if(times <days){
                list.add(idx);
                            //System.out.println(idx);

            }
            idx++;
        }
        int len = list.size();
        answer = new int[len];
        for(int i = 0 ;i < len ; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}