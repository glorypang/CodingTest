import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0,0};
    static int[] dy = {0, 0,-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            for(int j = 0; j < c ; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            int cnt =0;
            for(int j=0 ; j < N; j++){
                for(int k=0 ; k < M ; k++){
                    if(!visited[j][k] && map[j][k] == 1){
                        bfs(j,k);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0 ; i < 4 ;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx>= 0 && nx < N && ny >= 0 && ny < M ){
                    if(map[nx][ny] == 1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }

        }
    }

}