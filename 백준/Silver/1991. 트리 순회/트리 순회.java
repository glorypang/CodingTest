import java.io.*;
import java.util.*;

class Node {
    char name;
    Node left;
    Node right;

    public Node(char name) {
        this.name = name;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Character, Node> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            char a = str[0].charAt(0);
            char b = str[1].charAt(0);
            char c = str[2].charAt(0);

            map.putIfAbsent(a, new Node(a));
            Node parent = map.get(a);

            if (b != '.') {
                map.putIfAbsent(b, new Node(b));
                parent.left = map.get(b);
            }

            if (c != '.') {
                map.putIfAbsent(c, new Node(c));
                parent.right = map.get(c);
            }
        }

        Node root = map.get('A');

        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        StringBuilder post = new StringBuilder();

        preOrder(root, pre);
        inOrder(root, in);
        postOrder(root, post);

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    public static void preOrder(Node root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.name);
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    public static void inOrder(Node root, StringBuilder sb) {
        if (root == null) return;
        inOrder(root.left, sb);
        sb.append(root.name);
        inOrder(root.right, sb);
    }

    public static void postOrder(Node root, StringBuilder sb) {
        if (root == null) return;
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(root.name);
    }
}