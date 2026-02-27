import java.io.*;
import java.util.*;

public class Main{
    public static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];
        for(int i = 1; i <= N ; i++)
            Arrays.fill(map[i], INF);

        for(int i =1 ; i <= N ; i++){
            String str = br.readLine();
            for(int j = 1; j <= N; j++){
                if(str.charAt(j-1) == 'Y')
                    map[i][j] =1;
//                    map[i][j] = true;
            }
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int u = Integer.parseInt(st.nextToken());
//            int v = Integer.parseInt(st.nextToken());
        }

        for(int k = 1 ; k <= N; k++){
            for(int i = 1; i <= N ; i++){
                for(int j = 1 ; j <= N ; j++){
                    if(map[i][k] != INF && map[k][j] != INF)
                        map[i][j] = Math.min(map[i][k] +map[k][j], map[i][j]);
//                    if(map[i][k] && map[k][j])
//                        map[i][j] = true;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N ; i++){
            int cnt = 0;
            for(int j = 1 ; j <= N ; j++){
                if(i == j || map[i][j] == INF) continue;
                if(map[i][j] <= 2)
                    cnt++;
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}