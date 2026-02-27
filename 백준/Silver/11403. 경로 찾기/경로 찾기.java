import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[N][N];

        for(int i =0; i < N; i++){
            String[] str= br.readLine().split(" ");
            for(int j = 0 ; j < N; j++){
                if(str[j].equals("1")){
                    map[i][j] = true;
                }
            }
        }

        for(int k = 0 ; k < N ; k++){
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N; j++){
                    if(map[i][k] && map[k][j]) map[i][j] = true;
                }
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N; j++){
                System.out.print(map[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
}