import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int ans = 0;
        // 들어온 시간 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));

        for(int i = 0 ; i < jobs.length ; i++)
            pq.offer(new int[]{i, jobs[i][0], jobs[i][1]}); // 번호, 들어온 시간, 소요 시간
        
        int T = 0;
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((o1, o2)-> {
                int cmp = Integer.compare(o1[2], o2[2]);
                if(cmp == 0){
                    int cmp2= Integer.compare(o1[1], o2[1]);
                    if(cmp2 == 0){
                        return Integer.compare(o1[0], o2[0]);
                    }
                    return cmp2;
                }
                return cmp;
            }); //작업 가능한 애들 -> 우선순위 정렬 가능
        while(!pq.isEmpty() || !pq1.isEmpty()){
            boolean check = false;
            
            
            while(!pq.isEmpty() && T >= pq.peek()[1])
                pq1.offer(pq.poll());
            
            // for(int[] p : pq1)
                // System.out.println(T + " " +p[0] + " " + p[1] + " " + p[2]);
            
            while(!pq1.isEmpty()){
                int[] temp = pq1.poll();
                // System.out.println(T + " " +temp[0] + " " + temp[1] + " " + temp[2]);
                
                T += temp[2];
                ans += (T-temp[1]);
                check = true;
                //System.out.println(T + " " + (T-temp[1]));
                
                while(!pq.isEmpty() && T >= pq.peek()[1])
                pq1.offer(pq.poll());
            }
            if(!check)
                T++;
        }
        return (ans/jobs.length);
    }
}