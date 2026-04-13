import java.io.*;
import java.util.*;

public class Main {
    static HashMap<Integer, Node> map = new HashMap<>();
    static int columnCounter = 0;
    static HashMap<Integer, int[]> levelRange = new HashMap<>();

    static class Node{
        int num;
        Node left;
        Node right;
        int column;  // 열 번호
        int level;   // 레벨(깊이)

        Node(int n){
            this.num = n;
            this.left = null;
            this.right = null;
            this.column = 0;
            this.level = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        HashSet<Integer> children = new HashSet<>();

        // 노드 생성 및 트리 구조 만들기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            // 현재 노드가 map에 없으면 생성
            if(!map.containsKey(n)){
                map.put(n, new Node(n));
            }
            Node current = map.get(n);

            // 왼쪽 자식 연결
            if(left != -1){
                if(!map.containsKey(left)){
                    map.put(left, new Node(left));
                }
                current.left = map.get(left);
                children.add(left);
            }

            // 오른쪽 자식 연결
            if(right != -1){
                if(!map.containsKey(right)){
                    map.put(right, new Node(right));
                }
                current.right = map.get(right);
                children.add(right);
            }
        }

        // 루트 노드 찾기 (어떤 노드의 자식도 아닌 노드)
        Node root = null;
        for(int key : map.keySet()){
            if(!children.contains(key)){
                root = map.get(key);
                break;
            }
        }

        // 중위 순회로 열 번호와 레벨 할당
        inorder(root, 1);

        int maxWidth = 0;
        int resLevel = 0;
        List<Integer> list = new ArrayList<>(levelRange.keySet());
        Collections.sort(list);

        for(int lv :list){
            int[] range = levelRange.get(lv);
            int width = range[1] - range[0] +1;

            if(width > maxWidth){
                maxWidth = width;
                resLevel = lv;
            }
        }
        System.out.println(resLevel + " " + maxWidth);
    }

    // 중위 순회: 왼쪽 서브트리 -> 현재 노드 -> 오른쪽 서브트리
    static void inorder(Node node, int lv){
        if(node == null) return;

        // 왼쪽 서브트리 방문
        inorder(node.left, lv + 1);

        // 현재 노드 처리
        columnCounter++;
        node.level = lv;
        node.column = columnCounter;

        // 레벨별 최소/최대 열 번호 업데이트
        if(!levelRange.containsKey(lv)){
            levelRange.put(lv, new int[]{columnCounter, columnCounter});
        } else {
            int[] range = levelRange.get(lv);
            range[0] = Math.min(range[0], columnCounter);
            range[1] = Math.max(range[1], columnCounter);
        }

        // 오른쪽 서브트리 방문
        inorder(node.right, lv + 1);
    }
}