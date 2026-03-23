import java.math.*;
import java.util.*;

class Node{
    int num;
    Node left;
    Node right;
    
    Node(int n){
        this.num = n;
    }
}
class Solution {
    int count = 0;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0 ; i < numbers.length; i++){
            String temp = Long.toString(numbers[i], 2);
            StringBuilder sb = new StringBuilder();
            sb.append(temp);
            int cnt = temp.length();
            
            double num = Math.ceil(Math.log(cnt+1)/Math.log(2));
            double full = Math.pow(2, num)-1;
            int need = (int)full- cnt;
            while(need-- > 0)
                sb.insert(0, '0');
//             
            Node root = build(sb.toString(), 0, sb.length()-1);     
            count = 0;
            inorder(root);
            // System.out.println(count);
            
            for(char c : sb.toString().toCharArray()){
                if(c == '1')
                    count--;
            }
            if(count == 0){
                answer[i] = 1;
            }
            else{
                answer[i] = 0;
            }
            // System.out.println(sb.toString());
        }
        return answer;
    }
    
    Node build(String arr, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        int n = arr.charAt(mid)-'0';
        if(n == 0) return null;
        Node node = new Node(n);

        node.left = build(arr, left, mid - 1);
        node.right = build(arr, mid + 1, right);

        return node;
    }
    void inorder(Node node) {
        if (node == null) return;
        
        inorder(node.left);
        if(node.num == 1) 
            count++;
        // System.out.print(node.num + " ");
        inorder(node.right);
    }
}