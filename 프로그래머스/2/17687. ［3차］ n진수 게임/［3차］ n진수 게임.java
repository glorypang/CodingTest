class Solution {
    StringBuilder sb = new StringBuilder();
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder ans = new StringBuilder();
//         for(int i =0 ;  i <= 20; i++){
//             String s = i + "";
//             int len = s.length();
//             for(int j = 0 ; j < len ;j++){
//                 toBinary(s.charAt(j) - '0', n);
//             }
//         }
        
//         System.out.println(sb);
        
        for(int i = 0; i <= 100000; i++){
            toBinary(i, n);
        }
        // System.out.println(sb);
        
        int cnt = 0;
        for(int i = p-1; i < sb.length(); i+=m){
            cnt++;
            ans.append(sb.charAt(i));
            if(cnt == t) break;
        }
        //System.out.println(ans);
        return ans.toString();
    }
    
    void toBinary(int n, int k){
        StringBuilder temp = new StringBuilder();
        if(n == 0) temp.append("0");
        while(n != 0){
            switch(n%k){
                case 10: temp.append("A"); break;
                case 11: temp.append("B");break;
                case 12: temp.append("C");break;
                case 13: temp.append("D");break;
                case 14: temp.append("E");break;
                case 15: temp.append("F");break;
                default: temp.append(n%k);
            }
            n /= k;
        }

        sb.append(temp.reverse());
        
    }
}