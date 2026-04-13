import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[][] arr = new int[26][S.length()+1];

        for(int i = 1 ; i <= S.length(); i++){
            arr[S.charAt(i-1)-'a'][i]++;
        }

        for(int i = 0 ; i < 26; i++){
            for(int j = 1; j <= S.length() ; j++){
                arr[i][j] += arr[i][j-1];
            }
        }
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());

            char c = st.nextToken().charAt(0);
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            System.out.println(arr[c-'a'][n2+1]-arr[c-'a'][n1]);
        }
    }
}