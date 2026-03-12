import java.io.*;
import java.util.*;


public class Main {
    public static class Node{
        int idx;
        List<Node> child = new ArrayList<>();

        Node(int n){
            this.idx = n;
        }

        void add(Node n){
            child.add(n);
        }
        void remove(Node n){
            child.remove(n);
        }
        boolean contain(Node n){
            return child.contains(n);
        }
    }
    static int answer =0 ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Node> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Node rootNode = null;

        for (int i = 0; i < N; i++) {
            map.put(i, new Node(i));
        }
        for(int i = 0 ; i < N; i++){
            int num  = Integer.parseInt(st.nextToken());
            if(num == -1) rootNode = map.get(i);
            else map.get(num).add(map.get(i));
        }
        int K = Integer.parseInt(br.readLine());
        Node temp = map.get(K);
        if(temp == rootNode){
            System.out.println(0);
            System.exit(0);
        }
        for(int i = 0; i < N; i++){
            Node node = map.get(i);
            if(node.contain(temp)){
                node.remove(temp);
            }
        }
        dfs(rootNode);
        System.out.println(answer);
    }

    public static void dfs(Node node){
        if(node.child.isEmpty())
            answer++;

        for(Node next : node.child){
            dfs(next);
        }
    }
}
