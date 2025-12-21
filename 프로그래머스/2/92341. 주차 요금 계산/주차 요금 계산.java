import java.util.*;

class Car{
    String CarNum;
    String InTime;
    String OutTime;
    int during;
}

class Solution {
    public int[] solution(int[] fee, String[] records) {
        HashMap<String, Car> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        
        
        for(String s : records){
            String[] ss = s.split(" ");
            if(ss[2].equals("IN")){
                Car c = new Car();
                c.CarNum = ss[1];
                c.InTime = ss[0];
                
                map.put(ss[1], c);
            }
            else{
                System.out.print(ss[1] + " ");
                map.get(ss[1]).OutTime = ss[0];
                // System.out.println(map.get(ss[1]).OutTime);
                String[] timeIn = map.get(ss[1]).InTime.split(":");
                String[] timeOut = map.get(ss[1]).OutTime.split(":");
                int hour = Integer.parseInt(timeOut[0])*60 - Integer.parseInt(timeIn[0])*60;
                int min =  Integer.parseInt(timeOut[1])- Integer.parseInt(timeIn[1]);
                map.get(ss[1]).during = hour+min;
                                // 3시 20분  -> 4시 10분 60 -10
                // 3시 20분  -> 4시 30분 60 -10
                map1.put(Integer.parseInt(ss[1]), map1.getOrDefault(Integer.parseInt(ss[1]), 0)+hour+min);
                
                System.out.println(map1.get(Integer.parseInt(ss[1])));
                map.remove((ss[1]));
            }
        }
        
        if(!map.isEmpty()){
            for(String key : map.keySet()){
                String[] timeIn = map.get(key).InTime.split(":");
                int hour = 23*60 - Integer.parseInt(timeIn[0])*60;
                int min =  59- Integer.parseInt(timeIn[1]);
                
                map1.put(Integer.parseInt(key), map1.getOrDefault(Integer.parseInt(key), 0)+hour+min);
            }
        }
        
        List<Integer> keyset = new ArrayList<>(map1.keySet());
        
        Collections.sort(keyset);
        for(Integer key :keyset){
            System.out.println(key + ", " + map1.get(key));
        }
        
        List<Integer> list  =new ArrayList<>();
        int len = keyset.size();
        int[] answer = new int[len];
        for(int i = 0 ; i< keyset.size(); i++){
            if(map1.get(keyset.get(i)) <=fee[0]){
                answer[i] = fee[1];
            }
            else{
                answer[i] = (int)(fee[1]+(Math.ceil((double)(map1.get(keyset.get(i)) - fee[0])/fee[2]))*fee[3]);
                
            }
        }
            
        
        
        
        // for(String s : map.keySet()){
        //     System.out.println(s);
        // }
        return answer;
    }
}