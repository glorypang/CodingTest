class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        int i = 0;
    
        for(long n : numbers){
            if(n%2 == 1){
                long num = Long.lowestOneBit(n+1);
                int idx = (int)(Math.log(num)/Math.log(2));
                answer[i++] = n+ (long)Math.pow(2, idx-1);                     
            }else{
                answer[i++] = n+1;
            }
        }
        return answer;
    }
}