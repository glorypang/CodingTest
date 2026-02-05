import java.util.*;
class Genre{
    String name;
    List<int[]> list = new ArrayList<>(); // 고유 번호, 재생 수
    int total = 0; //총 재생 수
    
    Genre(String n, int[] li){
        this.name = n;
        this.list.add(li); 
    }
    
    void add(int[] li){
        this.list.add(li); 
    }
    
    void sort(){
        list.sort((a,b) -> {
            int cmp = Integer.compare(b[1], a[1]); 
            if (cmp != 0) return cmp; 
            return Integer.compare(a[0], b[0]); 
        });
    }
    
    void sum(){
        for(int i = 0 ; i < list.size(); i++){
            this.total += list.get(i)[1];
        }
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> map = new HashMap<>();
        for(int i =0; i < genres.length; i++){
            if(!map.containsKey(genres[i])){
                Genre gen = new Genre(genres[i], new int[]{i, plays[i]});
                map.put(genres[i], gen);
            }
            else{
                map.get(genres[i]).add(new int[]{i, plays[i]});
            }
        }

        for(String key : map.keySet()){
            Genre g = map.get(key);
            g.sort();
            g.sum();
        }
        
        List<String> tmp = new ArrayList<>(map.keySet());
        tmp.sort((o1, o2)-> Integer.compare(map.get(o2).total, map.get(o1).total));
        
        
        List<Integer> ans = new ArrayList<>();
        for(String s : tmp){
            Genre g = map.get(s);
            for(int i = 0 ; i < g.list.size(); i++){
                if(i > 1) break;
                ans.add(g.list.get(i)[0]);
            //System.out.println(g.list.get(i)[0]);
            }
        }
        int[] answer = new int[ans.size()];
        int idx =0;
        for(int i : ans){
            answer[idx++] = i;
        }
        
        return answer;
    }
}