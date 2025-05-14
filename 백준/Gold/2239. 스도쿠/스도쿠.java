import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[10][10];
    static int count = 0; // 빈칸 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0 ; i < 9 ;i++){
            String s = br.readLine();
            for(int j = 0; j < 9; j++){
                map[i][j] = s.charAt(j) - '0';
                if(map[i][j] == 0){
                    count++;
                }
            }
        }
        backtracking(0,0,0);
    }
    public static void backtracking(int row, int col, int depth){
        if(depth == count){
            printMap();
            System.exit(0); // 하나만 출력 후 종료
        }
        if(col == 9){
            backtracking(row+1, 0, depth);
            return;
        }

        if(row == 9){ // 81칸 모두를 다 탐색했다면
            return;
        }

        if(map[row][col] != 0){
            backtracking(row, col+1, depth);
            return;
        }

        for(int num = 1 ; num <= 9 ; num++){
            if(isVaild(row, col, num)){
                map[row][col] = num;
                backtracking(row,col+1,depth+1);
                map[row][col] = 0;
            }
        }
    }
    public static boolean isVaild(int row, int col, int k){
        // 세로 혹은 가로줄에 같은 숫자가 있는지 확인
        for(int i = 0 ; i < 9 ; i++) {
            if (map[i][col] == k || map[row][i] == k)
                return false;
        }
        // 3X3박스 안에 같은 숫자가 있는지 확인
        for(int i = (row/3)*3; i < (row/3)*3+3 ; i++){
            for(int j = (col/3)*3 ; j < (col/3)*3+3 ; j++){
                if(map[i][j] == k)
                    return false;
            }
        }
        return true;
    }
    public static void printMap(){
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

}