import java.util.*;

class Solution {
    static boolean[][][] visited; 
    static int size = 10;

    public int solution(String dirs) {
        int answer = 0;
        visited = new boolean[size + 1][size + 1][4]; // 0:상, 1:하, 2:좌, 3:우

        int cx = 5, cy = 5;

        for (char move : dirs.toCharArray()) {
            int nx = cx, ny = cy;
            int dir = -1, revDir = -1;

            switch (move) {
                case 'L': nx = cx - 1; dir = 2; revDir = 3; break;
                case 'R': nx = cx + 1; dir = 3; revDir = 2; break;
                case 'U': ny = cy + 1; dir = 0; revDir = 1; break;
                case 'D': ny = cy - 1; dir = 1; revDir = 0; break;
            }

            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;

            if (!visited[cx][cy][dir]) {
                visited[cx][cy][dir] = true;
                visited[nx][ny][revDir] = true;
                answer++;
            }

            cx = nx;
            cy = ny;
        }

        return answer;
    }
}
