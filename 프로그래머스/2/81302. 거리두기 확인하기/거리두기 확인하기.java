import java.util.*;
class Solution {
    static int n,m;
    static boolean[][] visited;
    static char[][] map;
    static int[][] distance;
    static int[] dx ={-1, 1, 0, 0};
    static int[] dy ={0, 0, -1, 1};
    static List<int[]> p; // 각 참가자들의 위치를 담을 Map
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);

        for(int i =0  ; i< places.length; i++){
            n = places[i].length;
            m = places[i][0].length();
            map = new char[n][m];
            
            p = new ArrayList<>(); 
            
            for(int j = 0 ; j < n ; j++){
                char[] c = places[i][j].toCharArray();
                for(int k = 0 ; k < m ; k++){
                    map[j][k] = c[k];
                    if(c[k] == 'P'){
                        p.add(new int[]{j,k});
                    }
                }
            }
            
            for(int j = 0; j < p.size(); j++){
                visited= new boolean[n][m];
                distance = new int[n][m];
                distance[p.get(j)[0]][p.get(j)[1]] =0;
                
                int len = bfs(p.get(j)[0], p.get(j)[1]);
                
                System.out.println();
                if(len <= 2) {
                    answer[i] = 0;
                    break;
                }
            }

        }    
        return answer;
    }
    public int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x,y});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            if(map[cx][cy] == 'P' && (cx != x || cy != y)){
                return distance[cx][cy];
            }

            
            for(int i =0 ; i< 4 ;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
               
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(!visited[nx][ny] && (map[nx][ny] == 'O' || map[nx][ny] == 'P')){
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[cx][cy] + 1;
                    }
                }
            }
        }
        return 100;
    }
}