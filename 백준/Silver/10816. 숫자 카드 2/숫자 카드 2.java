import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m ; i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(upperBound(num) - lowerBound(num)).append(" ");
        }
        System.out.println(sb);
    }
    public static int lowerBound(int key){
        int lo = 0;
        int hi = arr.length;

        while(lo < hi){
            int mid = (lo + hi)/2;

            if(key <= arr[mid])
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }

    public static int upperBound(int key){
        int lo = 0;
        int hi = arr.length;

        while(lo < hi){
            int mid = (lo + hi)/2;

            if(key < arr[mid]){
                hi = mid;
            }
            else
                lo = mid + 1;

        }
        return lo;
    }


}