class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr;
        for(int n[] : queries){
            for(int i = n[0] ; i <= n[1]; i++){
                answer[i] += 1;
            }
        }
        
        return answer;
    }
}