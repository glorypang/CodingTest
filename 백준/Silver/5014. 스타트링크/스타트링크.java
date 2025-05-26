import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] map;
    static boolean[] visited;

    static int N;
    static int pos;
    static int target;
    static int up,down;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        pos = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());
        map = new int[N+1];
        visited = new boolean[N + 1];

        int cnt = bfs(pos);
        if(cnt == -1){
            System.out.println("use the stairs");
        }
        else {
            System.out.println(cnt);
        }
    }
    public static int bfs(int pos) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(pos);
        map[pos] = 0;
        visited[pos] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();

            if(cur == target) {
                return map[cur];
            }
            int[] dx = {up, 0-down};
            for(int i = 0 ; i< 2 ; i++){
                int nx = cur + dx[i];

                if(nx > N || nx < 1) continue;
                if(visited[nx]) continue;
                visited[nx] = true;
                map[nx] = map[cur] + 1;
                q.offer(nx);
            }
        }
        return -1;

    }
}