import java.io.*;
import java.util.*;

public class Main {
    static class Customer {
        int startX, startY, endX, endY, distance;

        Customer(int startX, int startY, int endX, int endY, int distance) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
            this.distance = distance;
        }
    }

    static Customer[] customers;
    static int[][] map;
    static boolean[][] visited;
    static int[][] distance;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        distance = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int currentX = Integer.parseInt(st.nextToken()) - 1;
        int currentY = Integer.parseInt(st.nextToken()) - 1;

        customers = new Customer[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int startY = Integer.parseInt(st.nextToken()) - 1;
            int endX = Integer.parseInt(st.nextToken()) - 1;
            int endY = Integer.parseInt(st.nextToken()) - 1;
            customers[i] = new Customer(startX, startY, endX, endY, 0);
        }

        for (int i = 0; i < M; i++) {
            reset();
            bfs(currentX, currentY);

            for (Customer c : customers) {
                c.distance = distance[c.startX][c.startY] > 0 || (c.startX == currentX && c.startY == currentY) ? distance[c.startX][c.startY] : Integer.MAX_VALUE;
            }

            Arrays.sort(customers, (a, b) -> {
                if (a.distance != b.distance) return a.distance - b.distance;
                if (a.startX != b.startX) return a.startX - b.startX;
                return a.startY - b.startY;
            });

            Customer customer = null;
            for (Customer c : customers) {
                if (c.distance != Integer.MAX_VALUE) {
                    customer = c;
                    break;
                }
            }

            if (customer == null || customer.distance > fuel) {
                System.out.println(-1);
                return;
            }

            fuel -= customer.distance;

            int toDest = bfs2(customer.startX, customer.startY, customer.endX, customer.endY);
            if (toDest == -1 || toDest > fuel) {
                System.out.println(-1);
                return;
            }

            fuel -= toDest;
            fuel += toDest * 2;

            currentX = customer.endX;
            currentY = customer.endY;

            // Remove served customer
            List<Customer> temp = new ArrayList<>(Arrays.asList(customers));
            temp.remove(customer);
            customers = temp.toArray(new Customer[0]);
        }

        System.out.println(fuel);
    }

    public static void reset() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
            Arrays.fill(distance[i], 0);
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});
        distance[x][y] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        distance[nx][ny] = distance[cx][cy] + 1;
                    }
                }
            }
        }
    }

    public static int bfs2(int x, int y, int targetX, int targetY) {
        reset();
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});
        distance[x][y] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            if (cx == targetX && cy == targetY) {
                return distance[cx][cy];
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        distance[nx][ny] = distance[cx][cy] + 1;
                    }
                }
            }
        }

        return -1;
    }
}
