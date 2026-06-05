import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        long total = 0;
        for (int time : food_times) {
            total += time;
        }

        if (total <= k) {
            return -1;
        }

        PriorityQueue<Food> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);

        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(i + 1, food_times[i]));
        }

        long previous = 0;
        long remain = food_times.length;

        while (!pq.isEmpty()) {
            long current = pq.peek().time;
            long diff = current - previous;
            long spend = diff * remain;

            if (k < spend) {
                break;
            }

            k -= spend;
            previous = current;

            while (!pq.isEmpty() && pq.peek().time == current) {
                pq.poll();
                remain--;
            }
        }

        List<Food> list = new ArrayList<>(pq);
        list.sort((o1, o2) -> o1.index - o2.index);

        return list.get((int)(k % remain)).index;
    }

    static class Food {
        int index;
        int time;

        Food(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
}