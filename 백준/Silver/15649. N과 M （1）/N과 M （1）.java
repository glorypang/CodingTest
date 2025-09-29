
import java.util.*;
import java.io.*;
public class Main {
    static boolean visited[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        int[] res = new int[M];
        dfs(0, N, M, res);

    }

    public static void dfs(int dep, int N, int M, int[] res) {
        if(dep == M){
            for(int i = 0; i < M; i++){
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < N; i++){
            if(visited[i] == false){
                visited[i] = true;
                res[dep] = i+1;
                dfs(dep + 1, N, M, res);
                visited[i] = false;
            }
        }
    }
}