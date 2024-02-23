package educative.solution.grokkingcodinginterviewpatterns.topkelements;

import java.util.*;

class FrequentElements {
    public static List<Integer> topKFrequent(int[] arr, int k) {

        Map<Integer, Integer> frequency = new HashMap<>();
        for(int i : arr){
            frequency.put(i, frequency.getOrDefault(i, 0)+1);
        }
        if(frequency.size() < k){
            return new ArrayList<>();
        }
        PriorityQueue<Map.Entry<Integer, Integer> > queue = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for(Map.Entry<Integer, Integer> entry : frequency.entrySet()){
            queue.offer(entry);
        }
        List<Integer> result = new ArrayList<>();
        int i =0;
        while(i < k){
            result.add(queue.poll().getKey());
            i++;
        }

        return result;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] inputs = {
                {1, 3, 5, 12, 11, 12, 11, 12, 5},
                {1, 3, 5, 14, 18, 14, 5},
                {2, 3, 4, 5, 6, 7, 7},
                {9, 8, 7, 6, 6, 5, 4, 3, 2, 1},
                {2, 4, 3, 2, 3, 4, 5, 4, 4, 4},
                {1, 1, 1, 1, 1, 1},
                {2, 3}
        };
        int[] inputK = {3, 2, 1, 1, 3, 4, 2};
        for (int i = 0; i < inputK.length; i++) {
            List<Integer> result = topKFrequent(inputs[i], inputK[i]);
            System.out.print(i + 1);
            System.out.println(".\tInput: (" + Arrays.toString(inputs[i]) + ", " + inputK[i] + ")");
            System.out.println("\n\tTop " + inputK[i] + " frequent elements: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}