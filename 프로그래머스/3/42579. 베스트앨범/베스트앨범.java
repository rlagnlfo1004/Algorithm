import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> totalMap = new HashMap<>();
        HashMap<String, PriorityQueue<int[]>> songMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
            PriorityQueue<int[]> queue = songMap.getOrDefault(genres[i], new PriorityQueue<>((o1, o2) -> {
                    if(o1[1] == o2[1]) return o1[0] - o2[0];
                    else return o2[1] - o1[1];
                }));
            queue.add(new int[]{i, plays[i]});
            songMap.put(genres[i], queue);
        }
        
        List<String> genreList = new ArrayList<>(totalMap.keySet());
        Collections.sort(genreList, (o1, o2) -> totalMap.get(o2) - totalMap.get(o1));
        ArrayList<Integer> answerList = new ArrayList<>();
        
        for(String genre : genreList) {
            PriorityQueue<int[]> queue = songMap.get(genre);
            
            for(int i = 0; i < 2 && !queue.isEmpty(); i++) {
                answerList.add(queue.poll()[0]);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}