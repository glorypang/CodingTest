import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;
    static int maxSize = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        map = new int[n][m];

        for(int i = 0; i <n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        for(int i = 0; i <n ; i++){
            for(int j = 0; j <m; j++){
                if (map[i][j] == 1 && !visited[i][j]) {
                    int size = bfs(i,j);
                    maxSize = Math.max(maxSize,size);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(maxSize);
    }
    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0; i <4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(map[nx][ny] == 1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
