import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int n : moves){
            for(int i = 0 ; i <board.length; i++){
                if(board[i][n-1] != 0){
                    //System.out.println(board[i][n-1]);
                    if(st.isEmpty()){
                        st.push(board[i][n-1]);
                    }
                    else{
                        if(st.peek() == board[i][n-1]){
                            answer += 2;
                            st.pop();
                        }
                        else{
                            st.push(board[i][n-1]);
                        }
                    }
                    board[i][n-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}