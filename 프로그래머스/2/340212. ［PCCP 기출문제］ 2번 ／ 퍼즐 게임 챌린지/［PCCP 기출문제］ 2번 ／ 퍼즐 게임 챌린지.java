class Solution {
    int[] time;
    int[] diff;
    public int solution(int[] diffs, int[] times, long limit) {
        time = times;
        diff = diffs;
        int max = Integer.MIN_VALUE; 
        for(int n : diffs){
            if(max < n) max = n;
        }
        
        int low = 1; // 0
        int high = max; // 4
        
        int answer  = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low+high)/2; // 2
                
            if(res(mid) <= limit){
                high = mid-1; // 
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    
    long res(int n){
        long sum = 0;
        for(int i = 0 ; i < diff.length; i++){
            if(n >= diff[i]){
                sum += (long)time[i];
            }
            else {
                if(i == 0) sum += time[0];
                else{
                    sum += (long)((time[i]+time[i-1])*(diff[i]-n) + time[i]);               
                }    
            }
        }
        return sum;
    }
}