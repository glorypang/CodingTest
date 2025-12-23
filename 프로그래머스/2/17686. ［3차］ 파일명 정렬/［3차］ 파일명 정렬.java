import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[][] lib = new String[files.length][3];
        
        int cnt =0;
        for(String str : files){
            char[] chs = str.toCharArray();
            StringBuilder HEAD = new StringBuilder();
            StringBuilder NUMBER = new StringBuilder();
            StringBuilder TAIL = new StringBuilder();
            int i = 0;
            // HEAD
            while (i < chs.length && !Character.isDigit(chs[i])) {
                HEAD.append(chs[i]);
                i++;
            }

            // NUMBER
            while (i < chs.length && Character.isDigit(chs[i]) && NUMBER.length() < 5) {
                NUMBER.append(chs[i]);
                i++;
            }

            // TAIL
            while (i < chs.length) {
                TAIL.append(chs[i]);
                i++;
            }
            
            lib[cnt][0] = HEAD.toString();
            lib[cnt][1] = NUMBER.toString();
            lib[cnt++][2] = TAIL.toString();
        }
        
        Arrays.sort(lib,
            Comparator
                .comparing((String[] o) -> o[0], String.CASE_INSENSITIVE_ORDER)
                .thenComparingInt(o -> Integer.parseInt(o[1]))
        );

        String[] answer = new String[files.length];

        int i = 0;
        for(String[] str : lib){
            StringBuilder sb = new StringBuilder();
            sb.append(str[0]);
            sb.append(str[1]);
            sb.append(str[2]);
            // System.out.println(str[0] + ", " + str[1] + ", "+ str[2]);
            answer[i++] = sb.toString();             
        }
        
        return answer;
    }
}