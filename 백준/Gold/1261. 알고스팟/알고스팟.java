import org.w3c.dom.Node;

import javax.lang.model.type.ArrayType;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       M = Integer.parseInt(st.nextToken());
       N = Integer.parseInt(st.nextToken());
       map = new char[N][M];
       visited = new boolean[N][M];

       for(int i = 0; i < N; i++) {
           String line = br.readLine();
           char[] chars = line.toCharArray();
           for(int j = 0; j < M; j++) {
                map[i][j] = chars[j];
           }
       }
       bfs(0,0);
    }
    public static void bfs(int x, int y) {
        PriorityQueue<int[]> q = new PriorityQueue<>((n1, n2) -> n1[2] - n2[2]);
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cz = cur[2];

            if(cx == N - 1 && cy == M - 1){
                System.out.println(cz);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(!visited[nx][ny]){
                        if(map[nx][ny] == '1'){
                            q.add(new int[]{nx, ny, cz+1});
                            visited[nx][ny] = true;
                        }
                        else{
                            q.add(new int[]{nx, ny, cz});
                            visited[nx][ny] = true;

                        }
                    }
                }
            }
        }
    }

}
