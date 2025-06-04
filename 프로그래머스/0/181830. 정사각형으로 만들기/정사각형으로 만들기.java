class Solution {
    public int[][] solution(int[][] arr) {
        int[][] answer = {};
        
        int max = arr.length;
        for(int[] ar : arr){
            max = Math.max(max, ar.length);
        }
        System.out.println(max);
        
        answer = new int[max][max];
        
        for(int i = 0 ; i<arr.length; i++){
            for(int j = 0 ; j < arr[i].length; j++){
                answer[i][j] = arr[i][j];
            }
        }
        
        return answer;
    }
}