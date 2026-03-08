import javax.swing.*;
import java.io.*;
import java.util.*;

class Node{
    char name;
    Node left;
    Node right;

    public Node(char c){
        this.name = c;
    }
}
public class Main{
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Character, Node> map = new HashMap<>();


        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split(" ");
            char a = str[0].charAt(0);
            char b = str[1].charAt(0);
            char c = str[2].charAt(0);

            map.putIfAbsent(a, new Node(a));
            Node newNode = map.get(a);

            if(b != '.'){
                map.putIfAbsent(b, new Node(b));
                newNode.left = map.get(b);
            }
            if(c != '.' && newNode.right == null){
                map.putIfAbsent(c, new Node(c));
                newNode.right = map.get(c);
            }
        }
        Node root = map.get('A');

        List<Character> pre = new ArrayList<>();
        List<Character> in = new ArrayList<>();
        List<Character> post = new ArrayList<>();
        preOrder(root, pre);
        inOrder(root, in);
        postOrder(root, post);

        for(char c :pre)
            System.out.print(c);
        System.out.println();
        for(char c :in)
            System.out.print(c);
        System.out.println();

        for(char c :post)
            System.out.print(c);
    }

    public static void preOrder(Node root, List<Character> result){
        if(root ==null) return;
        result.add(root.name);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }
    public static void inOrder(Node root, List<Character> result){
        if(root ==null) return;
        inOrder(root.left, result);
        result.add(root.name);
        inOrder(root.right, result);
    }
    public static void postOrder(Node root, List<Character> result){
        if(root ==null) return;
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.name);
    }
}