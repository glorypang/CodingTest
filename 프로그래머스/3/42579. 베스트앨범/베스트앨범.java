import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playCount = new HashMap<>();
        Map<String, List<Song>> genreSong = new HashMap<>(); 
        
        for(int i =0  ; i< genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            playCount.put(genre, playCount.getOrDefault(genre,0)+play);
            
            if(!genreSong.containsKey(genre)){
                genreSong.put(genre, new ArrayList<>());
            }
            genreSong.get(genre).add(new Song(i, play));
        }
        
        List<String> sortedGenres = new ArrayList<>(playCount.keySet());
        sortedGenres.sort((a,b) -> playCount.get(b) - playCount.get(a));
        
        List<Integer> res=  new ArrayList<>();
        for(String genre : sortedGenres){
            List<Song> songs = genreSong.get(genre);
            songs.sort((a,b) ->{
                if(b.play != a.play) return b.play - a.play;
                return a.id - b.id;
            });
            
            res.add(songs.get(0).id);
            if(songs.size() > 1){
                res.add(songs.get(1).id);
            }
        }
        int len= res.size();
        int[] result = new int[len];
        for(int i =0  ; i < len ; i++){
            result[i] = res.get(i);
        }
        return result;
    }
    
    public class Song{
        int id;
        int play;
        
        Song(int id, int play){
            this.id = id;
            this.play = play;
        }
    }
}