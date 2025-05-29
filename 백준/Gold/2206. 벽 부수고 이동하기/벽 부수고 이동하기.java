import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx =  {-1, 1, 0, 0};
    static int[] dy =  {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i =0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }
        int len = bfs(0,0);
        System.out.println(len);
    }
    public static int  bfs(int x, int y){
        Queue<Data> q = new LinkedList<>();
        q.add(new Data(x,y,0, 0));
        visited[x][y][0] = true;
        while(!q.isEmpty()){
            Data cur = q.poll();

            if(cur.x == N-1 && cur.y == M-1){
                return cur.dist+1;
            }

            for(int i =0 ; i < 4 ; i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];

                if(nx >= 0 && ny >= 0 && nx < N  && ny < M){
                    // 벽이 아닌 경우
                    if(map[nx][ny] == 0 && !visited[nx][ny][cur.use]){
                        visited[nx][ny][cur.use] = true;
                        q.add(new Data(nx,ny,cur.use,cur.dist+1));
                    }
                    // 벽인데 아직 부수지 않은 경우
                    if(map[nx][ny] == 1 && !visited[nx][ny][1] && cur.use == 0){
                        visited[nx][ny][1] = true;
                        q.add(new Data(nx,ny, 1,cur.dist+1));
                    }
                }
            }
        }
        return -1;
    }

    public static class Data{
        int x, y;
        int use;
        int dist;

        public Data(int x, int y, int use, int dist) {
            this.x = x;
            this.y = y;
            this.use = use;
            this.dist = dist;
        }
    }
}