class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for(int[] size : sizes){
            if(size[0] >= size[1]){
                maxX = Math.max(maxX, size[0]);
                maxY = Math.max(maxY, size[1]);
            }
            else{
                maxX = Math.max(maxX, size[1]);
                maxY = Math.max(maxY, size[0]);
            }
        }
        
        return maxX*maxY;
    }
}