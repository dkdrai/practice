package educative.solution.grokkingcodinginterviewpatterns.topkelements;

import java.util.*;

public class FrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> frequency = new HashMap<>();
        for (String s : words)
            frequency.put(s, frequency.getOrDefault(s, 0) + 1);
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k)
                queue.poll();
        }
        List<String> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            result.add(0, queue.poll().getKey());
        }
        return result;

    }

    public static void main(String[] args) {
        String[] list = {"lets", "play", "cricket", "and", "then", "lets", "play", "badminton"};
        int k = 3;
        System.out.println(topKFrequent(list, k));

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );
        Map<String, Integer> frequency = new HashMap<>();
        for (String s : list)
            frequency.put(s, frequency.getOrDefault(s, 0) + 1);
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            queue.offer(entry);

        }
        System.out.println();
    }
}




