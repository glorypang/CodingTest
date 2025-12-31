class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int al = Integer.MAX_VALUE;int ar = Integer.MAX_VALUE;
        
        int l = 0; int r =0;
        int len = sequence.length;
        int sum = sequence[0]; // 5
        //System.out.println(l + ", " + r + ": " + sum);
        int cnt =0 ;
        // while(cnt++ < 10){
        while(true){
           if(sum < k){
               if(r == len-1) break;
               sum += sequence[++r];
           }
            else if(sum > k){
               sum -= sequence[l++]; 
            }
            else if(sum == k){
                if(al == Integer.MAX_VALUE){
                    al = l; // 2
                    ar = r; // 3
                }
                else{
                    if(ar-al > r-l){
                        al = l;
                        ar = r;
                    }
                }

                sum -= sequence[l++];
            }
            //System.out.println(l + ", " + r + ": " + sum);
            
        }
        //System.out.println(al + ", " + ar);
        return new int[]{al, ar};
    }
}