import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static int leafCount = 0;
    static int deleteNode;
    static boolean[] visited;
    static int root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int child = 0; child < n; child++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                root = child;
            } else {
                graph.get(parent).add(child);
                graph.get(child).add(parent); // 무방향
            }
        }

        deleteNode = Integer.parseInt(br.readLine());

        if (deleteNode == root) {
            System.out.println(0);
            return;
        }



        dfs(root, -1);
        System.out.println(leafCount);
    }
    static void dfs(int node, int parent) {
        if(node == deleteNode) return;
        boolean isLeaf = true;

        for(int next : graph.get(node)) {
            if(next != parent && next != deleteNode) {
                isLeaf = false;
                dfs(next, node);
            }
        }
        if(isLeaf) {
            leafCount++;
        }
    }
}
