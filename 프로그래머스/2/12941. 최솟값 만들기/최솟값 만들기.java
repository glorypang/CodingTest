import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        for(int a : A)
            list1.add(a);
        for(int a : B)
            list2.add(a);
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        for(int i = 0 ; i < A.length; i++){
            answer += list1.get(i) * list2.get(list2.size()-i-1);
        }
    
        return answer;
    }
}