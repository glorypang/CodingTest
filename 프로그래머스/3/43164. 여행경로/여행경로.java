import java.util.*;
class Solution {
    String[][] ticket;
    boolean[] visit;
    int len = 0;
    List<String> temp = new ArrayList<>();
    int cnt =0;
    List<List<String>> list = new ArrayList<>(); 
    public String[] solution(String[][] tickets) {
        ticket = tickets;
        len = tickets.length;
        visit = new boolean[len];
        
        for(int i = 0 ; i < len ; i++){
            if(tickets[i][0].equals("ICN")){
                visit[i] = true;
                temp.clear();
                temp.add("ICN");
                temp.add(tickets[i][1]);
                dfs(tickets[i][1]);
                visit[i] = false;
            }
        }

        
        for(int i = 0 ; i < list.size(); i++){
            for(String n : list.get(i)){
            }
            System.out.println();
        }
        
        Collections.sort(list, (o1, o2)->{
           for(int i = 0; i < o1.size(); i++){
               int cmp = o1.get(i).compareTo(o2.get(i));
               if(cmp != 0) return cmp;
           }
            return 0;
        });
        String[] answer = new String[list.get(0).size()];
        
        for(int i = 0 ; i < list.get(0).size(); i++){
            answer[i] = list.get(0).get(i);
        }
        
        
        return answer;
    }
    
    void dfs(String start){
        if(temp.size() == len+1){
            list.add(new ArrayList<>(temp)); // 복사본 저장
            return;
        }
        
        for(int i = 0 ; i < len ; i++){
            if(!visit[i] && ticket[i][0].equals(start)){
                visit[i] = true;
                temp.add(ticket[i][1]);
                dfs(ticket[i][1]);
                if(temp.size() > 0)
                    temp.remove(temp.size()-1);
                visit[i] = false;
            }
        }
    }
}