import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int cnt = 0; // 소수 개수

        for(int i = 0 ; i < n ; i++){
            int num = Integer.parseInt(st.nextToken());
            boolean isPrime = true;

            if(num == 1) 
                continue;
            
            for(int j = 2 ; j <= Math.sqrt(num) ; j++){
                if(num%j == 0){
                    isPrime =  false;
                    break;
                }
            }
            if(isPrime)
                cnt++;
        }
        System.out.println(cnt);
    }
}