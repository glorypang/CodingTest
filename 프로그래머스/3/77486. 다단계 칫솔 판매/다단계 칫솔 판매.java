import java.util.*;

class Solution {
    class Person{
        String name;
        String parent;
        ArrayList<String> ref = new ArrayList<>(); 
        int sum = 0;
        Person(String name, String pa){
            this.name = name;
            this.parent = pa;
        }
        void addRef(String str){
            this.ref.add(str);
        }
        void addSum(int n){
            sum += n;
        }
        
    } 
    HashMap<String, Person> map  =new HashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for(int i = 0 ; i < enroll.length; i++){
            Person p = new Person(enroll[i], referral[i]);
            map.put(enroll[i], p);
        }
        for(int i = 0 ; i < enroll.length; i++){
            if(!referral[i].equals("-")){
                Person p = map.get(referral[i]);
                p.addRef(enroll[i]);
            }
        }
        for(int i = 0 ; i < seller.length; i++){
            dfs(seller[i], amount[i]*100);
        }
        int[] answer = new int[enroll.length];
            
        for(int i = 0 ; i < enroll.length; i++){
            answer[i] = map.get(enroll[i]).sum;
        }
        return answer;
    }
    
    void dfs(String s, int price){
        if(price == 0) return;
        Person p = map.get(s);
        if(p.parent.equals("-")) {
            
            if(price>=10){
            //System.out.println(s + " " + (price - Math.floor(price*0.1)));
                p.addSum((int)(price - Math.floor(price*0.1)));
            }
            else{
            //System.out.println(s + " " + price);
                p.addSum(price);
                
            } 
            return;
        }
        else{
            //System.out.println(s + " " + price*0.9);
            p.addSum((int)(price - Math.floor(price*0.1)));
            dfs(p.parent, (int)(Math.floor(price*0.1)));
        }
    }
}