class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {};
        int x = 0;
        int y = 0;
        int n = board[0]/2;
        int m = board[1]/2;
        
        for(String key : keyinput){
            if(key.equals("left")){
                if(Math.abs(x-1) <= n){
                    x--;
                }                
            }
            else if(key.equals("right")){
                if(Math.abs(x+1) <= n){
                    x++;
                }                
            }
            else if(key.equals("up")){
                if(Math.abs(y+1) <= m){
                    y++;
                }                
            }
            else{
                if(Math.abs(y-1) <= m){
                    y--;
                } 
            }
        }
        return new int[]{x,y};
    }
}