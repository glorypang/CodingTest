import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        map = new char[n][m];
        distance = new int[n][m];

        for(int i = 0; i <n ; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            char[] chars = s.toCharArray();
            for(int j = 0; j <m; j++){

                map[i][j] = chars[j];
            }
        }
        bfs(0,0);
        System.out.println(distance[n-1][m-1]);
    }
    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        distance[x][y] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0; i <4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(map[nx][ny] == '1' && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        distance[nx][ny] = distance[cx][cy] + 1;
                    }
                }
            }
        }
    }
}
