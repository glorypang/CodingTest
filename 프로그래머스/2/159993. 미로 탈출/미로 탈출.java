import java.util.*;
class Solution {
    char[][] map;
    int[][] dis;
    boolean[][] visit;
    int r; int c;
    int[] dx = {0, 1, -1 ,0};
    int[] dy = {1, 0, 0, -1};
    int[] s_pos;
    int[] l_pos;
    int[] e_pos;
    public int solution(String[] maps) {
        int answer = 0;
        r = maps.length;
        c = maps[0].length();
        map = new char[r][c];
        dis = new int[r][c];
        visit = new boolean[r][c];
        for(int j = 0 ; j < maps.length; j++){
            for(int i = 0 ; i < maps[j].toCharArray().length; i++){
                char c = maps[j].charAt(i);
                map[j][i] = c;
                
                if(c == 'S') s_pos= new int[]{j,i};
                else if(c == 'E') e_pos= new int[]{j,i};
                else if(c == 'L') l_pos= new int[]{j,i};
            }
        }
        
        bfs(s_pos[0], s_pos[1], l_pos[0], l_pos[1]);
        if(dis[l_pos[0]][l_pos[1]] == 0) return -1;
        else answer += dis[l_pos[0]][l_pos[1]];
        bfs(l_pos[0], l_pos[1], e_pos[0], e_pos[1]);
         if(dis[e_pos[0]][e_pos[1]] == 0) return -1;
        else answer += dis[e_pos[0]][e_pos[1]];
        // for(int i = 0 ; i < r; i++){
        //     for(int j = 0; j < c; j++){
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        for(int i = 0 ; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(dis[i][j] + " ");
            }
            System.out.println();
        }
        
        return answer;
    }
    
    void bfs(int sx, int sy, int tx, int ty){
        dis = new int[r][c];
        visit = new boolean[r][c];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{sx,sy});
        dis[sx][sy] = 0;
        visit[sx][sy] =true;
        
        while(!dq.isEmpty()){
            int[] pos = dq.pollFirst();
            int px = pos[0]; 
            int py = pos[1]; 
            
            if(px == tx && py == ty){
                return;
            }
            
            int nx = 0; int ny = 0;
            for(int i = 0 ; i < 4 ;i++){
                nx = px + dx[i]; 
                ny = py + dy[i]; 
                if(nx < r && ny < c && nx >=0 && ny >= 0 && map[nx][ny] != 'X' && !visit[nx][ny] ){
                    dis[nx][ny] = dis[px][py] +1;
                    dq.offerLast(new int[]{nx,ny});
                    visit[nx][ny] =true;
                }
            }
        }
    }
}