import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N,M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i  < K;  i++){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1= Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for(int j = x1 ; j < x2 ; j++){
                for(int k = y1 ; k < y2 ; k++){
                    map[j][k] = 1;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int cnt =0 ;
        for(int i = 0 ; i  < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    int size = bfs(i,j);
                    list.add(size);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(list);
        for(int n : list){
            System.out.print(n + " ");
        }
    }
    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        int count = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            count++;

            for(int i = 0 ; i < 4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(map[nx][ny] == 0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return count;
    }
}