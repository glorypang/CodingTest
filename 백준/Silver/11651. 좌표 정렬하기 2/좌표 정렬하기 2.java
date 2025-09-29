import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] list = new int[N][2];

        for(int i =0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            else{
                return o1[1] - o2[1];
            }
        });

        for(int i = 0 ; i < N ;i ++){
            System.out.println(list[i][0] + " " + list[i][1]);
        }
    }
}