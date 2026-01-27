import java.util.*;
class Solution {
    int r; int c;
    List<List<Integer>> graph = new ArrayList<>();
    boolean[][] visit;
    public int solution(int n, int[][] computers) {
        r = computers.length; c = computers[0].length;
        for(int i = 0 ; i < r+1; i++)
            graph.add(new ArrayList<>());
        visit = new boolean[r+1][c+1];
        
        for(int i = 0 ; i < r; i++){
            for(int j = 0 ; j < c; j++){
                if(computers[i][j] != 0){
                    graph.get(i+1).add(j+1);
                    
                }
            }
        }
        
        // for(int i = 0 ; i < r+1; i++){
        //     System.out.print(i + "번 노드 : ");
        //     for(int j = 0 ; j < graph.get(i).size(); j++){
        //         System.out.print(graph.get(i).get(j));
        //     }
        //     System.out.println();
        // }
        
        int cnt = 0;
        for(int i = 1 ; i <= r; i++){
            for(int j = 0 ; j < graph.get(i).size(); j++){
                if(!visit[i][j] && graph.get(i).size() >= 1){
                    bfs(i, j);
                    // System.out.println(i + " " + j);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    void bfs(int x, int y){ 
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        
        while(!q.isEmpty()){ 
            int[] cur = q.poll();
            int cx = cur[0]; 
            int cy = cur[1]; 
            int num  = graph.get(cx).get(cy); 

            for(int i = 0; i < graph.get(num).size(); i++){ 
                if(!visit[num][i]){
                    visit[num][i] = true;
                    // System.out.println(num + " "  + i + " = "+ graph.get(num).get(i));
                    q.offer(new int[]{num, i}); 
                }
            }
            
        }
    }
}