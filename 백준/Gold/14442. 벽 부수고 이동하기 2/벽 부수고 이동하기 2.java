import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int N, M, K;

    static int[][] map;
    static boolean[][][] visited;
    static int[] dx =  {-1, 1, 0, 0};
    static int[] dy =  {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][K+1];

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
        q.add(new Data(x,y,0, 1));
        visited[x][y][0] = true;

        while(!q.isEmpty()){
            Data cur = q.poll();

            if(cur.x == N-1 && cur.y == M-1){
                return cur.dist;
            }

            for(int i =0 ; i < 4 ; i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];

                if(nx >= 0 && ny >= 0 && nx < N  && ny < M){
                    // 벽이 아닌 경우
                    if(map[nx][ny] == 0 && !visited[nx][ny][cur.breakCount]){
                        visited[nx][ny][cur.breakCount] = true;
                        q.add(new Data(nx,ny,cur.breakCount,cur.dist+1));
                    }
                    // 벽이고, 아직 부술 수 있음
                    else if(map[nx][ny] == 1 && cur.breakCount < K && !visited[nx][ny][cur.breakCount+1]){
                        visited[nx][ny][cur.breakCount+1] = true;
                        q.add(new Data(nx,ny, cur.breakCount+1,cur.dist+1));
                    }
                }
            }
        }
        return -1;
    }

    public static class Data{
        int x, y;
        int breakCount;
        int dist;

        public Data(int x, int y, int breakCount, int dist) {
            this.x = x;
            this.y = y;
            this.breakCount = breakCount;
            this.dist = dist;
        }
    }
}