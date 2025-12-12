import java.util.*;

class Solution {
    int r; int c;
    boolean[][] visit;
    int[][] dir = new int[][]{{-1,0}, {1,0}, {0,1},{0,-1}};
    int[][] map;
    int[][] dis;
    
    public int solution(int[][] maps) {
        map = maps;
        r = maps.length;
        c = maps[0].length;
        visit = new boolean[r][c];
        dis = new int[r][c];
        dis[0][0] =1;
        bfs(0, 0);
        // r = 1 , c = 5;
        return dis[r-1][c-1] == 0 ? -1 : dis[r-1][c-1];
    }
    
    void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>(); 
        q.add(new int[]{x, y});
        visit[x][y] = true;
        
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int cx = pos[0];
            int cy = pos[1];
            
            if(cx == r-1 && cy == c-1){
                return ;
            }
            
            for(int i = 0 ; i < 4; i++){
                int nx = cx + dir[i][0]; // 1
                int ny = cy + dir[i][1]; // 0
                
                if(nx >= 0 && ny >= 0 && nx < r && ny < c){     
                    if(!visit[nx][ny] && map[nx][ny] == 1){
                        q.add(new int[]{nx, ny});
                        dis[nx][ny] = dis[cx][cy] + 1;
                        visit[nx][ny] = true;
                        
                        // System.out.println(nx + ", " + ny);
                        // for(int j= 0; j < r ; j++){
                        //     for(int z = 0; z < c; z++){
                        //         System.out.print(dis[j][z] + " ");
                        //     }
                        //     System.out.println();
                        // }
                        //                             System.out.println();

                    }
                }
            }
        }
        return ;
    }
}