class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] map = new boolean[11][11][4];
        
        int x = 5;
        int y = 5;
        
        // 상:0 하:1 좌:2 우:3
        int i = 1;
        for(char c  : dirs.toCharArray()){
            int n = c == 'U' ? 0 : c == 'D' ? 1 : c == 'L'? 2 : 3; 
            //System.out.println(i++ + " :  (" +  x + ", " + y + " )  " + c + ": " + answer) ;
            if(c == 'U'){
                if(y == 10) continue;
                if(x < 0 || y< 0 ) continue;
                if(map[x][y][0]) answer--;
                map[x][y][0] = true;
                map[x][y+1][1] = true;
                if(y+1 < 11)
                    y++;
                
                
            }
            else if(c == 'D'){
                if(y == 0) continue;

                if(x < 0 || y< 0) continue;
                if(map[x][y][1]) answer--;
                map[x][y][1] = true;
                map[x][y-1][0] = true;

               if(y-1 >= 0)
                    y--;
            }
             else if(c == 'L'){
                if(x == 0) continue;
                if(x < 0 || y< 0) continue;
                if(map[x][y][2]) answer--;
                map[x][y][2] = true;
                map[x-1][y][3] = true;

                if(x-1 >= 0)
                    x--;

                 
            } else if(c == 'R'){
                if(x ==10) continue;
                if(x < 0 || y< 0) continue;
                if(map[x][y][3]) answer--;
                map[x][y][3] = true;
                map[x+1][y][2] = true;

                if(x+1 < 11)
                    x++;

            }
            if( x>=0 && y>=0)
            answer++;
                
        }
        
        return answer;
    }
}