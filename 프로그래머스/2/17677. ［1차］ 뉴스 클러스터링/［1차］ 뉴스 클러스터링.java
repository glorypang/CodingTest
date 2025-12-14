import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashMap<String, Integer> map3 = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        int gyo = 0;
        int hap =0;
        for(int i = 0 ; i < str1.length()-1; i++){
            String str = str1.substring(i, i+2);
            if(!Character.isLetter(str.charAt(0)) || !Character.isLetter(str.charAt(1))) continue;
            map1.put(str, map1.getOrDefault(str, 0)+1);
            map3.put(str, map3.getOrDefault(str, 0)+1);
            set.add(str);
            
        }
        

        for(int i = 0 ; i < str2.length()-1; i++){
            String str = str2.substring(i, i+2);
            if(!Character.isLetter(str.charAt(0)) || !Character.isLetter(str.charAt(1))) continue;
            map2.put(str, map2.getOrDefault(str, 0)+1);
            map3.put(str, map3.getOrDefault(str, 0)+1);
            set.add(str);
        }
        
        for(String key : map2.keySet()){
            if(map1.containsKey(key)) {
                gyo += Math.min(map1.get(key), map2.get(key));
            }
        }
        for(String key : set){
            hap += Math.max(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0));
        }
        
//         for(String key: map1.keySet()){
//             System.out.print(key + ", " + map1.get(key) + " ");
//         }
//         System.out.println();
//         for(String key: map2.keySet()){
//             System.out.print(key + ", " + map2.get(key) + " ");
//         }
//         System.out.println();
        
//         for(String key: map3.keySet()){
//             System.out.print(key + ", " + map3.get(key) + " ");
//         }
//         System.out.println();
        if(hap == 0 && gyo == 0){
            return 65536;
        }
        System.out.println(gyo + ", "+hap + " = " +(int)(((float)gyo/hap)*65536));
        return (int)(((float)gyo/hap)*65536);
    }
}