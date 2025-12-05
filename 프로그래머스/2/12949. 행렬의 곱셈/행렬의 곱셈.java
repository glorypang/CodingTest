class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r = arr1.length;
        int c = arr2[0].length;
        int[][] answer = new int[r][c];
        
        for(int i = 0 ; i < r; i++){ // 0 1
            int col = 0;
            for(int j = 0 ; j < c; j++){ // 0 1 2 3
                int sum = 0;
                for(int z = 0; z <arr1[0].length; z++){ // 0 1
                    sum += arr1[i][z] * arr2[z][j]; 
                }
                answer[i][col++] =sum;
            }
        }
        
        return answer;
    }
}