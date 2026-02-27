import java.io.*;
import java.util.*;

public class Main{
    public static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[N+1][N+1];
//        for(int i = 1; i <= N ; i++)
//            Arrays.fill(map[i], INF);

        for(int i =1 ; i <= M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u][v] = true;
        }

        for(int k = 1 ; k <= N; k++){
            for(int i = 1; i <= N ; i++){
                for(int j = 1 ; j <= N ; j++){
//                    if(map[i][k] != INF && map[k][j] != INF)
//                        map[i][j] = Math.min(map[i][k] +map[k][j], map[i][j]);
                    if(map[i][k] && map[k][j])
                        map[i][j] = true;
                }
            }
        }

        for(int i = 1; i <= N ; i++){
            int cnt = 0;
            for(int j = 1 ; j <= N ; j++) {
                if (i == j) continue;
                if(!map[i][j] && !map[j][i]) cnt++;
            }
            System.out.println(cnt);
        }
    }
}