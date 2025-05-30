import java.util.*;
class Solution {
    static int[][] dist;
    static boolean[][] visit;
    static int[][] map;
    static int N, M;
    static int[] dx ={-1, 1, 0, 0};
    static int[] dy ={0, 0, -1, 1};
    static int[] dx2 ={-2, 2, 0, 0};
    static int[] dy2 ={0, 0, -2, 2};
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        map = maps;
        dist = new int[N][M];
        visit = new boolean[N][M];
        
        
        
        return bfs(0, 0);
    }
    public int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            if(cx == N-1 && cy == M-1){
                return dist[cx][cy]+1;
            }
            for(int i = 0 ; i < 4 ;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(!visit[nx][ny] && map[nx][ny] == 1){
                        visit[nx][ny]= true;
                        q.offer(new int[]{nx, ny});
                        dist[nx][ny] = dist[cx][cy]+1;
                    }
                }
            }
            
        }
        return -1;
    }
}