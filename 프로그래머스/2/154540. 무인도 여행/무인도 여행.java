import java.util.*;
class Solution {
    int r; int c;
    char[][] map;
    boolean[][] visit;
    int[] dx = {0, 0 ,-1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    int sum ;
    public int[] solution(String[] maps) {
        r = maps.length; c = maps[0].length();
        map = new char[r][c];
        visit = new boolean[r][c];
        
        for(int i = 0 ;i < maps.length; i++){
            for(int j = 0 ; j < maps[i].toCharArray().length; j++){
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        // for(int a = 0 ; a < r; a++){
        //                 for(int b = 0 ; b < c; b++){
        //                     System.out.print((visit[a][b] ? "T" : "F") + " ");
        //                 }
        //                 System.out.println();
        //             }
        //                 System.out.println();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < r; i++){
            for(int j = 0 ; j < c; j++){
                if(map[i][j] != 'X' && !visit[i][j]){
                    sum = 0;
                    bfs(i, j);
                    list.add(sum);
                        
                    // for(int a = 0 ; a < r; a++){
                    //     for(int b = 0 ; b < c; b++){
                    //         System.out.print((visit[a][b] ? "T" : "F") + " ");
                    //     }
                    //     System.out.println();
                    // }
                    //     System.out.println();
                }
            }
        }
        
        if(list.size() == 0) return new int[]{-1};
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        int idx =0;
        for(int i : list){
            answer[idx++] = i;
        }
        
        
        // for(int i = 0 ; i < r; i++){
        //     for(int j = 0 ; j < c; j++){
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return answer;
    }
    
    void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            sum += map[cx][cy] - '0';
            
            for(int i= 0 ; i < 4 ;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx < r && ny < c&& nx >=0 && ny >= 0 && map[nx][ny] != 'X'){
                    if(!visit[nx][ny]){
                        visit[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            
        }
    }
}