import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visitied;
    static int n;
    static int[][] map;
    static int cnt =0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visitied = new boolean[n][n];

        for(int i = 0; i < n ; i++){
            String line = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                if(!visitied[i][j] && map[i][j] == 1){
                    list.add(dfs(i,j));
                    cnt = 0;
                }
            }
        }
        int len = list.size();
        int[] res = new int[len];
        for(int i = 0; i < len ; i++){
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        System.out.println(len);
        for(int n : res){
            System.out.println(n);
        }
    }
    public static int dfs(int x, int y){
        visitied[x][y] = true;
        cnt++;
        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx < n && nx >= 0 && ny < n && ny >= 0 ){
                if(!visitied[nx][ny] && map[nx][ny] == 1){
                    dfs(nx, ny);
                }
            }
        }
        return cnt;
    }
}
