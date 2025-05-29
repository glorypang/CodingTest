import java.util.*;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static int N, M;
    static int[] dx ={-1, 1, 0, 0};
    static int[] dy ={0, 0, -1, 1};    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        map = maps;
        visited = new boolean[N][M];
        dist = new int[N][M];
        return bfs(0,0);
    }
    public int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            if(cx == N-1 && cy == M-1){
                        return dist[N-1][M-1]+1;

            }
            
            for(int i = 0 ; i< 4 ;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                 if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                     if(!visited[nx][ny] && map[nx][ny] == 1){
                         q.offer(new int[]{nx, ny});
                         visited[nx][ny] = true;
                         dist[nx][ny] = dist[cx][cy] +1;
                     }
                 }

            }
        }
        return -1;
    }
}