import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int w, h;
    static char[][] map;
    static int[][] fireTime;
    static int[][] sangTime;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> fireQ;
    static Queue<int[]> sangQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            fireTime = new int[h][w];
            sangTime = new int[h][w];
            fireQ = new LinkedList<>();
            sangQ = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                Arrays.fill(fireTime[i], -1);
                Arrays.fill(sangTime[i], -1);
            }

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '*') {
                        fireQ.offer(new int[]{i, j});
                        fireTime[i][j] = 0;
                    } else if (map[i][j] == '@') {
                        sangQ.offer(new int[]{i, j});
                        sangTime[i][j] = 0;
                    }
                }
            }

            bfsFire();
            String result = bfsSang();
            System.out.println(result);
        }
    }

    public static void bfsFire() {
        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (map[nx][ny] == '#' || fireTime[nx][ny] != -1) continue;

                fireTime[nx][ny] = fireTime[x][y] + 1;
                fireQ.offer(new int[]{nx, ny});
            }
        }
    }

    public static String bfsSang() {
        while (!sangQ.isEmpty()) {
            int[] cur = sangQ.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 탈출 조건
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                    return Integer.toString(sangTime[x][y] + 1);
                }

                if (map[nx][ny] == '#' || sangTime[nx][ny] != -1) continue;

                // 불보다 빨리 도착해야 함
                if (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= sangTime[x][y] + 1) continue;

                sangTime[nx][ny] = sangTime[x][y] + 1;
                sangQ.offer(new int[]{nx, ny});
            }
        }
        return "IMPOSSIBLE";
    }
}
