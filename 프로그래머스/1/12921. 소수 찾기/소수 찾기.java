import java.util.Arrays;

class Solution {
    public int solution(int n){
        int answer = 0;
        boolean[] arr1 = isPrime(n);
        for(int i=1; i<=n; i++){
            if(arr1[i] == true){
                answer += 1;
            }
        }
        return answer;
    }
    public static boolean[] isPrime(int n){
        boolean[] arr = new boolean[n+1];
        
        Arrays.fill(arr,true);
        arr[0]=false;
        arr[1]=false;
        
        for(int i =2; i<=Math.sqrt(n); i++){
            if(arr[i] == true){
                for(int j=i*i;j<=n;j+=i){
                    arr[j] = false;
                }
            }
        }
        return arr;
        
        
     }
}
