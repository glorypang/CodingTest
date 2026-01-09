import java.util.*;
class Solution {
    char[][] map;
    boolean[][] visit;
    int[][] dis;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int r; int c;
    public int solution(String[] board) {
        int answer = 0;
        r = board.length; c = board[0].length();
        map = new char[r][c];
        visit = new boolean[r][c];
        dis = new int[r][c];
        
        int[] start = new int[2];
        int[] target = new int[2];
        for(int i =0; i  <r ; i++){
            for(int j = 0 ; j  < c; j++){
                map[i][j] = board[i].charAt(j);
                if(board[i].charAt(j) == 'R') start = new int[]{i, j};
                else if(board[i].charAt(j) == 'G') target =  new int[]{i, j};
            }
        }
        
        int n = bfs(start[0], start[1], target[0], target[1]);
        
       
        return n;
    }
    
    int bfs(int x, int y, int tx, int ty){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        dis[x][y] = 0;
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int cx = pos[0];
            int cy = pos[1];
            // dis[cx][cy] = dis[x][y] +1;
            if(cx == tx && cy == ty) return dis[cx][cy];
            System.out.println(cx +", " +cy);
            visit[cx][cy] = true;
            
                //  for(int a =0  ;a < r ; a++){
                //     for(int b = 0 ; b  <c; b++){
                //         System.out.print(dis[a][b] + " ");
                //     }
                //     System.out.println();
                // }
                //                     System.out.println();

            
            for(int i = 0; i < 4 ; i++){
                int nx = cx;
                int ny = cy;
                    
                while (true) {
                    int tx2 = nx + dx[i];
                    int ty2 = ny + dy[i];
                    if (tx2 < 0 || tx2 >= r || ty2 < 0 || ty2 >= c || map[tx2][ty2] == 'D')
                        break;
                    nx = tx2;
                    ny = ty2;
                }
                    
                if (!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    dis[nx][ny] = dis[cx][cy] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return -1;    
    }
}