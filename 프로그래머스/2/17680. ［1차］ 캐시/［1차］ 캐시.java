import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Deque<String> dq = new LinkedList<>();
      
        if(cacheSize == 0){
            return cities.length * 5;
        }
        //초기 설정
        for(int i = 0 ; i < cities.length; i++){
            String str = cities[i].toLowerCase();
            // System.out.print(cities[i] + ", ");
            if(!dq.contains(str)){ // dq에 없다면
                dq.addLast(str);
                if(dq.size() > cacheSize)
                    dq.removeFirst();
                answer += 5;
                // System.out.println("5");
            }
            else{ // dq에 이미 있다면
                answer+= 1;
                dq.remove(str);
                dq.addLast(str);
                // System.out.println("1");
                
            }
//             for(String s : dq){
//                 System.out.print(s + " ");
//             }
//             System.out.println();
            
        }
        
        return answer;
    }
}