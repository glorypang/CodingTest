import java.util.*;
import java.io.*;

public class Main{
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] map = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            Arrays.fill(map[i], INF);
        }

        for(int i =0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[u][v] = Math.min(map[u][v], w);
        }

        for(int k = 1 ; k <= N ; k++){
            for(int i = 1 ; i <= N ; i++){
                for(int j = 1 ; j <= N; j++){
                    if(map[i][k] != INF && map[k][j] != INF)
                        map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
                }
            }
        }

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N; j++){
                if(map[i][j] == INF || i == j) System.out.print(0 + " ");
                else
                    System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}