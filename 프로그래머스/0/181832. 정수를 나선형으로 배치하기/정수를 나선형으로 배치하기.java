class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int x = 0;
        int y = 0;
        
        char dir = 'r';
        for(int i =0  ; i< n*n ; i++){
            answer[x][y] = i+1;
            if(dir == 'r'){
                if(y == n-1 || answer[x][y+1] != 0){
                    dir = 'd';
                    x++;
                }
                else{
                    y++;
                }
            }
            else if(dir == 'd'){
                if(x == n-1 || answer[x+1][y] != 0){
                    dir = 'l';
                    y--;
                }else{
                    x++;
                }
            }
            else if(dir == 'l'){
                if(y == 0 || answer[x][y-1] != 0){
                    dir = 'u';
                    x--;
                }else{
                    y--;
                }
            }
            else{
                if(x == 0 || answer[x-1][y] != 0){
                    dir = 'r';
                    y++;
                }else{
                    x--;
                }
            }
        }
        return answer;
    }
}