import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<int[]>> graph;
    static final int INF = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        graph = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        for(int i =0 ; i < n+1; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        for(int i =0  ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(true){
                int e = Integer.parseInt(st.nextToken());
                if(e == -1) break;
                int w = Integer.parseInt(st.nextToken());
                graph.get(s).add(new int[]{e, w});
                graph.get(e).add(new int[]{s, w});
            }
        }
        Node target1 = dfs(1,0);
        Arrays.fill(visited, false);

        Node target2 = dfs(target1.node, 0);
        System.out.println(target2.distance);
    }
    public static Node dfs(int start, int distance){
        visited[start] = true;
        Node node = new Node(start, distance);

        for(int[] next : graph.get(start)){
            int nextNode = next[0];
            int weight = next[1];

            if(!visited[nextNode]){
                Node newNode = dfs(nextNode, distance+weight);
                if(newNode.distance > node.distance){
                    node = newNode;
                }
            }
        }
        return node;
    }
    public static class Node{
        int node;
        int distance;

        public Node(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
}