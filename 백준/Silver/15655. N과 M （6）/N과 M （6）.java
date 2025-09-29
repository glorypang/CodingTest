
import java.util.*;
import java.io.*;
public class Main {
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    static int[] list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N + 1];
        int[] res = new int[M];
        Arrays.sort(list);
        dfs(0,0,N, M, res);
        System.out.print(sb);

    }

    public static void dfs(int start, int dep, int N, int M, int[] res) {
        if(dep == M){
            for(int i = 0; i < M; i++){
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < N; i++){
            if(!visited[i]) {
                visited[i] = true;
                res[dep] = list[i];
                dfs(i, dep + 1, N, M, res);
                visited[i] = false;
            }
        }
    }
}