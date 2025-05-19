import java.util.*;

class Solution {
    static List<List<int[]>> graph;
    static final int INF = Integer.MAX_VALUE;
    static int[] dist;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 간선 + 중복 간선 처리
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int cost = road[i][2];

            addOrUpdateEdge(a, b, cost);
            addOrUpdateEdge(b, a, cost); // 양방향
        }

        dijkstra(1);

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }

    // 중복 간선 있을 경우 더 짧은 걸로 갱신
    private void addOrUpdateEdge(int from, int to, int weight) {
        boolean updated = false;
        for (int j = 0; j < graph.get(from).size(); j++) {
            int[] edge = graph.get(from).get(j);
            if (edge[0] == to) {
                if (edge[1] > weight) {
                    graph.get(from).set(j, new int[]{to, weight});
                }
                updated = true;
                break;
            }
        }
        if (!updated) {
            graph.get(from).add(new int[]{to, weight});
        }
    }

    public void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        dist[start] = 0;
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if (curDist > dist[curNode]) continue;

            for (int[] next : graph.get(curNode)) {
                int nextNode = next[0];
                int weight = next[1];
                int newDist = curDist + weight;

                if (dist[nextNode] > newDist) {
                    dist[nextNode] = newDist;
                    pq.offer(new int[]{nextNode, newDist});
                }
            }
        }
    }
}
