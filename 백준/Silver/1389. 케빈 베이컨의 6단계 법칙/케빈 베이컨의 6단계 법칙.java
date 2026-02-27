import java.util.*;
import java.io.*;

public class Main{
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            Arrays.fill(map[i], INF);
        }
        for(int i =0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
//            map[u][v] = Math.min(map[u][v]);
            map[u][v] = 1;
            map[v][u] = 1;
        }

        for(int k = 1 ; k <= N ; k++){
            for(int i = 1 ; i <= N ; i++){
                for(int j = 1 ; j <= N; j++){
                    if(map[i][k] != INF && map[k][j] != INF)
                        map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
//                    if(map[i][k] && map[k][j]) map[i][j] = true;
                }
            }
        }


        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i = 1 ; i <= N ; i++){
            int cnt =0;
            for(int j = 1 ; j <= N; j++) {
                if(i == j && map[i][j] != INF) continue;
                cnt += map[i][j];
            }
            m.put(i, cnt);
        }

        List<Integer> sorted = new ArrayList<>(m.keySet());
        sorted.sort((o1, o2) -> {
            int cmp =m.get(o1) - m.get(o2);
            if(cmp != 0) return cmp;
            return o1-o2;
        });



        System.out.println(sorted.get(0));
    }
}