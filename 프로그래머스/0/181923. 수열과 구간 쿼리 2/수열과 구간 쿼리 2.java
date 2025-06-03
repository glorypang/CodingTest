class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int idx =0;
        
        for(int[] q : queries){
            boolean check = false;
            int min = Integer.MAX_VALUE;
            for(int i = q[0] ; i <= q[1] ; i++){
                if(arr[i] > q[2]){
                    min = Math.min(min, arr[i]);
                    check = true;
                }
            }
            if(!check){
                answer[idx++] = -1;
            }
            else{
                answer[idx++] = min;
            }
        }
        return answer;
    }
}