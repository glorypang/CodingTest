import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> list;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 1;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if( N== 0 && M == 0) break;

            list = new ArrayList<>();
            visit = new boolean[N+1];
            for(int i = 0 ; i <= N ;i ++)
                list.add(new ArrayList<>());

            for(int i = 0; i< M; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                list.get(u).add(v);
                list.get(v).add(u);
            }

            int cnt = 0;
            for(int i = 1 ; i <= N; i++){
                if(!visit[i]){
                    if(dfs(i, 0))
                        cnt++;
                }
            }

            if(cnt == 1)
                System.out.println("Case " + T++ + ": There is one tree.");
            else if(cnt >= 2)
                System.out.println("Case " + T++ + ": A forest of " + cnt + " trees.");
            else
                System.out.println("Case " + T++ + ": No trees.");
        }
    }

    static boolean dfs(int node, int par){
        visit[node] = true;

        for(int next: list.get(node)){
            if(!visit[next]){
                if(!dfs(next, node)) 
                    return false;
            }
            else if(next != par)
                return false;
        }
        return true;
    }
    }
