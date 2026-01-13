import java.util.*;
class Solution {
    class Music{
        String startTime;
        String endTime;
        int during;
        
        Music(String a, String b, int c){
            this.startTime = a;
            this.endTime = b;
            this.during= c;
        
        }
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        HashMap<String, Music> map = new HashMap<>(); // 제목, 재생시간
        m = normalize(m);
        for(int i = 0 ; i < musicinfos.length; i++){
            Deque<String> dq = new ArrayDeque<>(); // 음악을 하나씩 담을
            String[] musics = musicinfos[i].split(",");
            musics[3] = normalize(musics[3]);
            char[] chs = musics[3].toCharArray();
            StringBuilder sb = new StringBuilder();
             Music mu = new Music(musics[0], musics[1], toTime(musics[0], musics[1]));
            map.put(musics[2], mu);
            
            

//             int cnt = 0;
//             for(int j = 1; j < chs.length; j++){
//                 if(chs[j-1] == '#') continue;
//                 if(Character.isLetter(chs[j])){
//                     cnt++;
//                 }
//                 else if(chs[j] == '#'){
//                     cnt++;
//                 }
//             }
//             if(Character.isLetter(chs[chs.length-1])){
//                 cnt++;
//             }
            // System.out.println("cnt : "+  cnt);
            // ---- dq에 넣기 
            
            sb.append(musics[3]);
            int total = sb.length();
            while(total < map.get(musics[2]).during){
                sb.append(musics[3]);
                total += musics[3].length();
            }
            
            while(total != map.get(musics[2]).during){
                sb.deleteCharAt(sb.length()-1);
                total--;
                // if(Character.isLetter(sb.charAt(sb.length()-1))) {
                //     sb.deleteCharAt(sb.length()-1);
                //     total--;
                // }
                // else{
                //     sb.deleteCharAt(sb.length()-1);
                //     sb.deleteCharAt(sb.length()-1);
                //     total--;
                // }
            }
            
            // sb = new StringBuilder(
            //         sb.substring(0, map.get(musics[2]).during)
            // );
            
            if(sb.indexOf(m) < 0){
               map.remove(musics[2]);
            }
        }
        
        if(map.size() == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("(None)");
            return sb.toString();
        }
        List<String> keyset = new ArrayList<>(map.keySet());
        Collections.sort(keyset, (o1, o2)-> {
            int cmp =Integer.compare(map.get(o2).during, map.get(o1).during);
            if(cmp != 0) return cmp;
            
            return map.get(o1).startTime.compareTo(map.get(o2).startTime);
        });
        
        // for(String key : sortedMap.keySet()){
            //System.out.println(key + ", " + sortedMap.get(key).during);
        // }
        return keyset.get(0);
        
    }
    
    int toTime(String t1, String t2){
        String[] temp1 = t1.split(":");
        String[] temp2 = t2.split(":");
        
        int time1 = Integer.parseInt(temp1[0])*60 + Integer.parseInt(temp1[1]);
        int time2 = Integer.parseInt(temp2[0])*60 + Integer.parseInt(temp2[1]);
        
        return time2 - time1;
    }
    
    String normalize(String s) {
        return s
            .replace("B#", "b")
            .replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g")
            .replace("A#", "a");
    }

}