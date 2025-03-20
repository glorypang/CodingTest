import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A  = Integer.parseInt(st.nextToken());
        int B  = Integer.parseInt(st.nextToken());
        int C  = Integer.parseInt(br.readLine());

        A = B+C >=60 ? A+(B+C)/60 : A;
        A = A%24;
        B = (B+C)%60;
        System.out.println(A +" " + B);
    }
}