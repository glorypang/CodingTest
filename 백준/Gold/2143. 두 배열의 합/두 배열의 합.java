import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long T = Long.parseLong(st.nextToken());
        // A 입력
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++)
            arr1[i] = Integer.parseInt(st.nextToken());

       // B 입력
        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m ; i++)
            arr2[i] = Integer.parseInt(st.nextToken());

        ArrayList<Long> sumA = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            long sum = 0;
            for(int j = i; j < n ; j++){
                sum += arr1[j];
                sumA.add(sum);
            }
        }

        HashMap<Long, Integer> sumB= new HashMap<>();
        for(int i = 0; i < m ; i++){
            long sum = 0;
            for(int j = i; j <m ; j++){
                sum +=arr2[j];
                sumB.put(sum, sumB.getOrDefault(sum,0)+1);
            }
        }

        long cnt = 0;
        for(long a: sumA){
            long need = T-a;
            if(sumB.containsKey(need)){
                cnt += sumB.get(need);
            }
        }

        System.out.println(cnt);
    }
}