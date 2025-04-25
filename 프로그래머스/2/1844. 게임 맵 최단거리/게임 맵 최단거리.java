import java.util.*;
class Solution {
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] distance;
    static int[][] map;
    int dis = 0;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        map = maps;
        visited = new boolean[n][m];
        distance = new int[n][m];
        distance[0][0] = 1;
        return bfs(0,0) == 0 ? -1 : bfs(0,0);          

    }
    public int bfs(int x, int y){
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            dis++;

            for(int i = 0; i< 4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >=0 && nx <n && ny >=0 && ny < m){
                    if(!visited[nx][ny] && map[nx][ny] == 1){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        distance[nx][ny] = distance[cx][cy]+1;
                        // System.out.println("현재 좌표 x: " + nx + ", y: " + ny + ", " + distance[nx][ny]);
                    }

                }
            }
        }
        return distance[n-1][m-1];
    }
}