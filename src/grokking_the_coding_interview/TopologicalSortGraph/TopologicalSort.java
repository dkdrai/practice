package grokking_the_coding_interview.TopologicalSortGraph;

import java.util.*;

class TopologicalSort {
  public static List<Integer> sort(int vertices, int[][] edges) {
    List<Integer> sortedOrder = new ArrayList<>();
    if(edges.length == 0){
      return sortedOrder;
    }
    Map<Integer, Integer> degree = new HashMap<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for(int i =0 ; i<vertices; i++){
      degree.put(i, 0);
      graph.put(i, new ArrayList<>());
    }

    for(int i = 0; i<edges.length; i++){
      int parent = edges[i][0];
      int child = edges[i][1];
      graph.get(parent).add(child);
      degree.put(child, degree.get(child)+1);
    }
    Queue<Integer> queue = new LinkedList<>();
    for(Map.Entry<Integer, Integer>entry : degree.entrySet()){
      if(entry.getValue() == 0){
        queue.add(entry.getKey());
      }
    }

    while(!queue.isEmpty()){
      int parent = queue.poll();
      sortedOrder.add(parent);
      List<Integer> list = graph.get(parent);
      for(int child : list){
        degree.put(child, degree.get(child)-1);
        if(degree.get(child) == 0){
          queue.add(child);
        }
      }
    }
    if(vertices != sortedOrder.size()){
      return  new ArrayList<>();
    }
    return sortedOrder;
  }

  public static void main(String[] args) {
    List<Integer> result = TopologicalSort.sort(4,
        new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
    System.out.println(result);

    result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
        new int[] { 2, 1 }, new int[] { 3, 1 } });
    System.out.println(result);

    result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
        new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
    System.out.println(result);
  }
}