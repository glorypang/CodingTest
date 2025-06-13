import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] h1 = {1,2,3,4,5};
        int[] h2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] h3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int len = answers.length;
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        for(int i = 0 ; i< len; i++){
            if(answers[i] == h1[i%h1.length]) cnt1++;
            if(answers[i] == h2[i%h2.length]) cnt2++;
            if(answers[i] == h3[i%h3.length]) cnt3++;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, cnt1);
        map.put(2, cnt2);
        map.put(3, cnt3);
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));
            
        List<Integer> list = new ArrayList<>();
        int max = -1;
        for(Map.Entry<Integer, Integer> entry : entryList){
            //System.out.println(entry.getKey() + ", " + entry.getValue());
            if(max == entry.getValue()){
                list.add(entry.getKey());
                max = entry.getValue();
            }
            else if(max < entry.getValue()){
                list.clear();
                max = entry.getValue();
                list.add(entry.getKey());
            }
        }
        int size = list.size();
        answer = new int[size];
        int idx = 0;
        for(int n : list){
            answer[idx++] = n;
        }
        return answer;
    }
}