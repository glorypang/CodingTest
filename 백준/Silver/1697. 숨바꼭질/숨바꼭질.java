import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n, k, 0));
    }
    public static int bfs(int pos, int target, int depth) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        visited[pos] = true;
        q.add(new int[]{pos, depth});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cdepth = cur[1];
            if (cx == target) {
                return cdepth;
            }
            int[] nextPos = {2*cx, cx-1, cx+1};
            for(int nx : nextPos) {
                if(nx >= 0 && nx < 100001 && !visited[nx]) {
                    visited[nx] = true;
                    q.offer(new int[]{nx, cdepth+1});
                }
            }
        }
        return -1;
    }
}