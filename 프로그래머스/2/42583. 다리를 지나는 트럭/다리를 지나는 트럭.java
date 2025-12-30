import java.util.*;
class Solution {
    class Car{
        int weight;
        int time; 
        
        Car(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        List<Car> list = new ArrayList<>();
        
        int idx = 0;
        int total = 0;
        while(true){
            answer++; //
            
            //System.out.println(answer+ "초");
            while(!list.isEmpty() && list.get(0).time == bridge_length){
                total -= list.get(0).weight; //
                list.remove(0);
            }
            
            if(idx < truck_weights.length && total + truck_weights[idx] <= weight){ 
                list.add(new Car(truck_weights[idx], 0)); // 4 5
                total += truck_weights[idx]; // 
                idx++;
            }
            for(int i =0 ; i < list.size(); i++){
                list.set(i, new Car(list.get(i).weight, list.get(i).time+1)); 
            }
            
            // for(int i =0 ; i < list.size(); i++){
            //     System.out.println(list.get(i).weight + ", " + list.get(i).time); 
            // }
            
            if(list.size()== 0) break;
           
            
            
        }
        return answer;
    }
}