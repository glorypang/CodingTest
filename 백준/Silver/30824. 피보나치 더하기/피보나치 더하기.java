
import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<Long> fibo = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        fibo.add(1L); fibo.add(1L);
        while(true){
            int n = fibo.size();
            long next = fibo.get(n-1) + fibo.get(n-2);
            if(next > 1_0000_0000_0000_0000L) break;
            fibo.add(next);
        }

        int T = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());

            boolean check = false;
            if(k ==1) check = fibo.contains(x);
            else if(k == 2){
                for(long num : fibo){
                    if(fibo.contains(x - num)){
                        check = true;
                        break;
                    }
                }
            }
            else if(k == 3){
                for(long num : fibo){
                    if(num > x) break;
                    long target = x - num;

                    int l = 0; int r = fibo.size()-1;
                    while(true){
                        if(l >= fibo.size() || r < 0) break;
                        long sum = fibo.get(l) + fibo.get(r);

                        if(sum < target) l++;
                        else if( sum > target) r--;
                        else {
                            check = true;
                            break;
                        }
                    }
                }
            }

            if(check) System.out.println("YES");
            else System.out.println("NO");
        }


    }
}