import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < (int)Math.pow(2,n)-1; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        TreeNode root = buildTree(0, list.size()-1, list);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                System.out.print(node.val+ " ");
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            System.out.println();
        }
    }
    public static TreeNode buildTree(int start, int end, List<Integer> list) {
        if(start > end) return null;

        int mid = (start + end) /2;
        TreeNode node = new TreeNode();
        node.val = list.get(mid);
        node.left = buildTree(start, mid-1, list);
        node.right = buildTree(mid+1, end, list);

        return node;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    }
}