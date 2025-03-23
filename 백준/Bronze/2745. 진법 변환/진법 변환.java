import java.io.*;
import java.util.*;


public class Main{
    public static double to_number(String str, int n){
        double sum = 0;
        for(int i = str.length()-1 ; i >= 0 ; i--){ // 4 3 2 1 0
            char c= str.charAt(i);
            if(Character.isDigit(c)){
                sum +=  (c - '0') * Math.pow(n, str.length()-1 -i);

            }else {
                sum += (str.charAt(i) - 55)* Math.pow(n, str.length()-1 -i);
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        System.out.printf("%.0f",to_number(str, n));
    }
}