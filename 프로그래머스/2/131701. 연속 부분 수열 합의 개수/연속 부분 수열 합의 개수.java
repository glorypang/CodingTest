import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        Deque<Integer> dq = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        int sum = 0;
        for(int i = 0 ; i <elements.length; i++){
            list.add(elements[i]);
            set.add(elements[i]);
            sum += elements[i];
        }
        set.add(sum);
        
        for(int i = 0 ; i <elements.length-2; i++){
            list.add(elements[i]);
        }


        
        for(int i = 2; i < elements.length; i++){ // 카운트 개수
            int std = 0;
            int z; int j;
            for(j = 0 ; j < i; j++){ // 0 1 
                std += elements[j]; // 5 j =2
            }
            set.add(std);
            //System.out.println(std);

            z = j; //2
            
            for( ; z < list.size(); z++){
                if(z-i == elements.length -1) break;
                std += list.get(z);
                std -= list.get(z-i);
                //System.out.println(list.get(z-i) +", " +list.get(z) + ", " + std);
                set.add(std);
            }
        }
        
        return set.size();
    }
}