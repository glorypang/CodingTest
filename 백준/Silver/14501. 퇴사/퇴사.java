import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int ans = 0;
    static int[] T;
    static int[] P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        for(int i = 0; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0); // 첫 일과 최대금액 초기값 0
        System.out.println(ans);
    }

    public static void dfs(int n, int pay){
        if(n >= N){
            ans = Math.max(ans, pay);
            return ;
        }
        if(n + T[n] <= N){
            dfs(n+T[n], pay+P[n]);
        }
        dfs(n+1, pay);
    }
}
