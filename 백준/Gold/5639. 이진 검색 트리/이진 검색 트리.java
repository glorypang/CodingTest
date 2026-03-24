import java.io.*;
import java.util.*;

class Node{
    int num;
    Node left;
    Node right;

     Node(int n){
        this.num = n;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        Node root = null;

        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;

            int num = Integer.parseInt(line);

            if (root == null) root = new Node(num);
            else insert(root, num);
        }

        postOrder(root);
    }
    public static void insert(Node node, int num){
        if(node.num > num){
            if(node.left == null)
                node.left = new Node(num);
            else{
                insert(node.left, num);
            }
        }
        else if(node.num < num){
            if(node.right == null)
                node.right = new Node(num);
            else{
                insert(node.right, num);
            }
        }
    }

    public static void postOrder(Node node){
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
}
