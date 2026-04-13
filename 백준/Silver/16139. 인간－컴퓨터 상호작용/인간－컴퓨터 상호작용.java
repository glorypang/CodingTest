import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[][] arr = new int[26][S.length()+1];

        // 각 문자 위치 표시 (1-based로 저장)
        for(int i = 0; i < S.length(); i++){
            arr[S.charAt(i)-'a'][i+1]++;
        }

        // 누적 합 계산
        for(int i = 0; i < 26; i++){
            for(int j = 1; j <= S.length(); j++){
                arr[i][j] += arr[i][j-1];
            }
        }

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            // l~r 구간: arr[r+1] - arr[l]
            System.out.println(arr[c-'a'][r+1] - arr[c-'a'][l]);
        }
    }
}