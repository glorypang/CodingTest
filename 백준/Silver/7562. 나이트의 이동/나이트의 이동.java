import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int[] pos = new int[4];
    static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
    static int[] dy = {2, 1, -2, -1, -2, -1, 2, 1};
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            distance = new int[N][N];

            int idx = 0;
            for(int i = 0; i < 2; i++){
                st = new StringTokenizer(br.readLine());
                pos[idx++] = Integer.parseInt(st.nextToken());
                pos[idx++] = Integer.parseInt(st.nextToken());
            }

            bfs();
        }
    }
    public static void bfs() {
        visited[pos[0]][pos[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{pos[0], pos[1]});
        distance[pos[0]][pos[1]] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            if(cx == pos[2] && cy == pos[3]){
                System.out.println(distance[cx][cy]);
                break;

            }
            for(int i = 0 ; i < 8 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx <N && ny >= 0 && ny < N){
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        distance[nx][ny] += distance[cx][cy] +1;
                    }
                }
            }
        }
    }
}