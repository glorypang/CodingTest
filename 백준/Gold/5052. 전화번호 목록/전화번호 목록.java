import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int i = 0; i < t; i++) {
            boolean check = false;
            int n = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                list.add(br.readLine());
            }
            Collections.sort(list);
            for(int j = 0; j < n-1; j++) {
                if(list.get(j+1).startsWith(list.get(j))) {
                    check = true;
                    System.out.println("NO");
                    break;
                }
            }
            if(!check)System.out.println("YES");

        }
    }
}