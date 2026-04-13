import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());

            char c = st.nextToken().charAt(0);
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for(int j = n1; j <= n2; j++){
                if(S.charAt(j) == c)
                    cnt++;
            }
            System.out.println(cnt);
        }
    }
}