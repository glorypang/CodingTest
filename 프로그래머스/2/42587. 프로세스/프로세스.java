import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<Integer> dq = new LinkedList<>();
        // 1 2 3 4
        
        for(int i = 0 ; i < priorities.length; i++){
            dq.offerLast(i);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < priorities.length; i++){
            map.put(i, priorities[i]);
        }
   
        
        Arrays.sort(priorities);
        int[] ans = new int[priorities.length]; // 위치별로 언제 실행됐는지 기록
        for(int i = 0 ; i < priorities.length; i++){
            while(true){
                int n = dq.pollFirst();
                // System.out.print("n = " + n + " ");
                if(map.get(n) != priorities[priorities.length - i - 1]){
                    dq.offerLast(n);
                    // for(int a : dq){
                    //     System.out.print(a + " ");
                    // }
                    // System.out.println();
                }
                else{
                    ans[n] = i+1;
                    // System.out.println();

                    break;
                }
            }
        }
        // for(int a : ans){
        //     System.out.println(a);
        // }
        return ans[location];
    }
}
