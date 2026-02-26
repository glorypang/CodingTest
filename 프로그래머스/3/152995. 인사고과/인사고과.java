import java.util.*;
class Solution {
    class Person{
        int idx = 0; // 원호 0;
        int rank = 0;
        int sum = 0;
        int g = 0; // 근무
        int t = 0; // 태도 
        
        Person(int n, int m, int s){
            this.g = n;
            this.t = m;
            this.sum = s;
        }
    }
    public int solution(int[][] scores) {
        int answer = 0;
        
        HashMap<Integer, Person> map = new HashMap<>();
        int idx = 0;
        for(int[] s : scores){
            Person p = new Person(s[0], s[1], s[0] + s[1]);
            map.put(idx++, p);
        }
        
        List<Integer> sorted = new ArrayList<>(map.keySet());
        sorted.sort((o1, o2) -> {
            Person a = map.get(o1);
            Person b = map.get(o2);
            int cmp = Integer.compare(b.g, a.g);     // g desc
            if (cmp != 0) return cmp;
            return Integer.compare(a.t, b.t);        // t asc (중요)
        });
        
        
        // maxT로 탈락 판정
        int maxT = -1;
        for (int key : sorted) {
            Person p = map.get(key);

            if (p.t < maxT) {            // 앞쪽에 g 더 크고 t도 더 큰 사람이 존재 => 탈락
                if (key == 0) return -1; // 원호 탈락
                map.remove(key);         // 탈락자 제거
            } else {
                maxT = Math.max(maxT, p.t); // 생존이면 maxT 갱신
            }
        }
        
        
        List<Integer> sortedRank = new ArrayList<>(map.keySet());
        sortedRank.sort((o1, o2)-> {
            int cmp = Integer.compare(map.get(o2).sum, map.get(o1).sum);
            return cmp;
        });
        
        int cnt = 1;
        int interval = 0;
        int max = map.get(sortedRank.get(0)).sum;
        for(int s : sortedRank){
            if(map.get(s).sum == max){
                interval++;
            }
            else{
                max = map.get(s).sum;
                cnt += interval;
                interval = 1;
            }
            //System.out.println(s + " " + cnt  + " " + interval);
            // System.out.println(s + " " + map.get(s).sum);
            if(s == 0) return cnt;
        }
        
        
        return -1;
    }
}