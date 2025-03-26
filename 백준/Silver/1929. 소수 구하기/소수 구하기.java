import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] num = new boolean[N+1];
        Arrays.fill(num,true);

        num[0] = false;
        num[1] = false;

        for(int i =2 ;i <= Math.sqrt(N); i++){
            if(num[i]){
                for(int j = i*i ; j <= N ; j += i)
                    num[j] = false;
            }
        }
        for(int i = M ;i <= N ;i++){
            if(num[i]){
                System.out.println(i);
            }
        }
    }
}