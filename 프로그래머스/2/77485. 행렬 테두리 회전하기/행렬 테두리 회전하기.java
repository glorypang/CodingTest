import java.util.*;

class Solution {
    int r; int c;
    int[][] map;
    int[][] copy;
    public int[] solution(int rows, int columns, int[][] queries) {
        r = rows; c= columns;
        map = new int[r][c];
        copy = new int[r][c];
        List<Integer> list = new ArrayList<>();
        int idx = 1;
        for(int i = 0; i < r; i++){
            for(int j = 0 ; j < c; j++){
                map[i][j] = idx; 
                copy[i][j] = idx++; 
            }
        }
        for(int[] q : queries){
            int x1 = q[0]; int y1 = q[1];
            int x2 = q[2]; int y2 = q[3];
            
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = y1; i < y2; i++){
                copy[x1-1][i] = map[x1-1][i-1];
                pq.offer(map[x1-1][i-1]);
            }
            
            for(int i = x1; i < x2; i++){ 
                copy[i][y2-1] = map[i-1][y2-1];
                pq.offer(map[i-1][y2-1]);
            }
            
            for(int i = y2-2; i >= y1-1; i--){ 
                copy[x2-1][i] = map[x2-1][i+1];                
                pq.offer(map[x2-1][i+1]);
            }
            
            for(int i = x2-2; i >= x1-1; i--){ 
                copy[i][y1-1] = map[i+1][y1-1];
                pq.offer(map[i+1][y1-1]);
            }
            
            for(int i = 0 ; i < r; i++){
                for(int j = 0 ;j < c; j++){
                    map[i][j] = copy[i][j];
                }
            }
            list.add(pq.poll());
        }
        int[] answer = new int[list.size()];
        idx = 0 ;
        for(int a : list){
            answer[idx++] = a;
        }
        return answer;
    }
}