import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 1; i <= n; i++){
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
            max = Math.max(max, map.get(s));
        }

        List<String> list = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key) == max){
                list.add(key);
                max = map.get(key);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}