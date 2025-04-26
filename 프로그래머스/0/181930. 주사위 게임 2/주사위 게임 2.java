class Solution {
    public int solution(int a, int b, int c) {
        int[] arr = new int[7];
        arr[a]++;arr[b]++;arr[c]++;
   
        int maxCnt = 0;
        for(int i = 1 ; i< 7 ; i++){
            maxCnt= Math.max(maxCnt, arr[i]);
        }
        System.out.println(maxCnt);
        if(maxCnt == 1){
            return a+b+c;
        }
        else if(maxCnt == 2){
            return (a+b+c) * (a*a+b*b+c*c);
        }
        else{
            return (a+b+c) * (a*a+b*b+c*c)* (a*a*a+b*b*b+c*c*c);
        }
    }
}