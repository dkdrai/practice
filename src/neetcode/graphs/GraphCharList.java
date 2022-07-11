package neetcode.graphs;

import java.util.*;

public class GraphCharList {
    private Map<Character, List<Character>> map = new HashMap<>();

    public void addVertex(Character s) {
        map.put(s, new LinkedList<Character>());
    }


    public void addEdge(Character source,
                        Character destination,
                        boolean bidirectional) {
        if (!map.containsKey(source))
            addVertex(source);
        if (destination != null) {
            if (!map.containsKey(destination))
                addVertex(destination);
            map.get(source).add(destination);
            if (bidirectional == true) {
                map.get(destination).add(source);
            }
        }
    }

    public int getShortestPath(Character src, Character dest) {
        if (src == dest) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();
        Node currentNode = new Node(src, 0);
        queue.add(currentNode);
        visited.add(src);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.value == dest) {
                return current.count;
            }
            for (char c : map.get(current.value)) {
                if (!visited.contains(c)) {
                    visited.add(c);
                    queue.add(new Node(c, current.count + 1));
                }
            }
        }
        return -1;
    }


    static class Node {
        public char value;
        public int count;

        public Node(char value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static void main(String arg[]) {
        GraphCharList intGraph = new GraphCharList();
/*        intGraph.addEdge(0, 8, false);
        intGraph.addEdge(0, 1, false);
        intGraph.addEdge(0, 5, false);

        intGraph.addEdge(1, 0, false);
        intGraph.addEdge(5, 0, false);
        intGraph.addEdge(5, 8, false);

        intGraph.addEdge(8, 0, false);
        intGraph.addEdge(8, 5, false);*/

        intGraph.addEdge('w', 'x', true);
        intGraph.addEdge('w', 'v', true);

        intGraph.addEdge('x', 'y', true);
        intGraph.addEdge('z', 'y', true);

        intGraph.addEdge('z', 'v', true);
        System.out.println(intGraph.getShortestPath('w', 'z'));
    }
}
