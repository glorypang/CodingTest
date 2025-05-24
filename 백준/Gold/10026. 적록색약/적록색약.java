import javax.swing.tree.TreeNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] map2;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        map2 = new int[N][N];
        for(int i = 0; i < N ; i++){
            String line = br.readLine();
            char[] chars = line.toCharArray();
            for(int j = 0; j < N ; j++){
                if(chars[j] == 'R'){
                    map[i][j] = 1;
                    map2[i][j] = 1;
                }
                else if(chars[j] == 'G'){
                    map[i][j] = 2;
                    map2[i][j] = 1;

                }
                else if(chars[j] == 'B'){
                    map[i][j] = 3;
                    map2[i][j] = 2;

                }
            }
        }
        int cnt = 0;
        int idx =1;
        //일반인
        while(idx < 4){
            visited = new boolean[N][N];

            for(int i = 0; i < N ; i++){
                for(int j = 0; j < N ; j++){
                    if(map[i][j] == idx && !visited[i][j]){
                        bfs(i, j, idx, map);
                        cnt++;
                    }
                }
            }
            idx++;
        }
        System.out.print(cnt+ " ");
        // 색약
        cnt = 0;
        idx = 1;
        while(idx < 3){
            visited = new boolean[N][N];

            for(int i = 0; i < N ; i++){
                for(int j = 0; j < N ; j++){
                    if(map2[i][j] == idx && !visited[i][j]){
                        bfs(i, j, idx, map2);
                        cnt++;
                    }
                }
            }
            idx++;
        }

        System.out.print(cnt);

    }
    public static void bfs(int x, int y, int idx, int[][] map){
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0 ; i< 4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >=0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == idx){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }


    }
}