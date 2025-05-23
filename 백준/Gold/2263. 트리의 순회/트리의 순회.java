import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] inOrder, postOrder;
    static Map<Integer, Integer> inMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        inOrder = new int[n];
        postOrder = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            inMap.put(inOrder[i], i);  // 값 → 인덱스 매핑
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        TreeNode root = buildTree(0, n - 1, 0, n - 1);

        preOrder(root);
    }

    public static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val+ " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static TreeNode buildTree(int inStart, int inEnd, int postStart, int postEnd) {
        if( inStart > inEnd || postStart > postEnd){
            return null;
        }

        int rootVal = postOrder[postEnd];
        TreeNode root = new TreeNode(rootVal);


        int inRootIdx = inMap.get(rootVal);
        int leftSize = inRootIdx - inStart;

        root.left = buildTree(inStart, inRootIdx - 1, postStart, postStart + leftSize -1);
        root.right = buildTree(inRootIdx + 1, inEnd, postStart+ leftSize, postEnd -1);


        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            this.val = x;
        }

    }
}
