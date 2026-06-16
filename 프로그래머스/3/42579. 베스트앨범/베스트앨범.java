import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genMap = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            String gen = genres[i];
            int play = plays[i];
            
            genMap.put(gen, genMap.getOrDefault(gen, 0) + play);
            songMap.putIfAbsent(gen, new ArrayList<>());
            songMap.get(gen).add(new Song(i, play));
        }
        
        List<String> genList = new ArrayList<>(genMap.keySet());
        genList.sort((o1, o2) -> genMap.get(o2) - genMap.get(o1));
        
        List<Integer> result = new ArrayList<>();
        
        for(String gen : genList) {
            List<Song> songs = songMap.get(gen);
            Collections.sort(songs);
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i).index);
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    class Song implements Comparable<Song> {
        int index;
        int play;
        
        public Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
        
        @Override
        public int compareTo(Song s) {
            if(s.play != play) return s.play - play;
            return index - s.index;
        }
    }
}