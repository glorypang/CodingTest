import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] book  = new int[1440+10];
        // for(String[] books : book_time){
        //     System.out.println(book[0] + "," + book[1]);
        // }
        
        for(String[] books : book_time){
            System.out.println(toMinute(books[0]) + ", " + (toMinute(books[1])+10));
            for(int i = toMinute(books[0]) ; i <= toMinute(books[1])+9; i++){
                book[i]++;
            }
        }
        
        for(int i = 0; i <= 1440; i++){
            answer  = Math.max(answer, book[i]);
        }

        return answer;
    }
    
    int toMinute(String Time){
        String[] tmp = Time.split(":");
        int hour = Integer.parseInt(tmp[0])*60;
        int min = Integer.parseInt(tmp[1]);
        
        return hour+min;
    }
}