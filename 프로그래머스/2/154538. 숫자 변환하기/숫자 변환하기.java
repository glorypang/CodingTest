import java.util.*;
class Solution {
    int cnt = Integer.MAX_VALUE;
    int num;
    public int solution(int x, int y, int n) {
        int answer = 0;
        num = n; // 3
        dfs(x,y); //0 24 
        return cnt == Integer.MAX_VALUE ? -1 : cnt;
    }
    void dfs(int sum, int target){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{target, 0}); // 10 0
        
        while(!q.isEmpty()){
            int[] n = q.poll();
            if(sum == n[0]){
                cnt = Math.min(cnt, n[1]);
                //System.out.println(cnt);
                return;
            }
            if(n[0] < sum)
                continue;
            
            
//             if(n[0] > target){
//                 continue;
//             }
            
//             if(n[0] == target){
//                 cnt = Math.min(cnt, n[1]);
//                 break;
//             }
            int[] arr;
            
            if(n[0] % 6 == 0){
                arr = new int[]{n[0]/2, n[0]/3, n[0]-num};
            }
            else if(n[0] % 3 == 0){
                arr = new int[]{n[0]/3, n[0]-num};            
            }
            else if(n[0] % 2 == 0){
                arr = new int[]{n[0]/2, n[0]-num};            
            }
            else{
                arr = new int[]{n[0]-num};
            }

            //int[] arr = new int[]{n[0]*3, n[0]*2, n[0]+num};
            for(int i = 0; i < arr.length; i++){
                q.offer(new int[]{arr[i], n[1]+1}); // q=(40,1) 90,2 60,2 35,2 60,2 40,2 25,2 
            }
        }
        
//         if(sum == target){
//             cnt = Math.min(cnt, depth);
//             //System.out.println(cnt);
//             return;
//         }
//         if(target < sum)
//             return;
        
//         int[] arr;
//         if(target % 6 == 0){
//             arr = new int[]{target/2, target/3, target-num};
//         }
//         else if(target % 3 == 0){
//             arr = new int[]{target/3, target-num};            
//         }
//         else if(target % 2 == 0){
//             arr = new int[]{target/2, target-num};            
//         }
//         else{
//             arr = new int[]{target-num};
//         }
        
//         for(int i = 0 ; i < arr.length; i++){
//             dfs(sum, arr[i], depth+1);                                     
//         }
    }
}