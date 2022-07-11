package neetcode.graphs;

import java.util.*;


public class GenericGraph<T> {

    private Map<T, List<T>> map = new HashMap<>();


    public static void main(String args[]) {

        // Object of graph is created.
        GenericGraph<Character> g = new GenericGraph<Character>();

        // edges are added.
        // Since the graph is bidirectional,
        // so boolean bidirectional is passed as true.
       /* g.addEdge('a', 'c', true);
        g.addEdge('a', 'b', true);
        g.addEdge('b', 'd', true);
        g.addEdge('c', 'e', true);
        g.addEdge('d', 'f', true);
        g.addEdge('e', null, true);
        g.addEdge('f', null, true);*/



/*        g.addEdge('i', 'j', true);
        g.addEdge('i', 'k', true);
        g.addEdge('k', 'm', true);
        g.addEdge('k', 'l', true);
        g.addEdge('o', 'n', true);*/


        //       System.out.println(g.haspathDfsUndi('i', 'm', new HashSet<>()));
        //     System.out.println(g.haspathDfsUndiRec('i', 'm', new HashSet<>()));
/*        System.out.println(g.hasPathBfs('f', 'a'));
        System.out.println(g.haspathDfs('a', 'e'));
        System.out.println(g.hasPathBfs('a', 'e'));*/

        /*
         * a -> b -> c
         * b -> d
         * c -> e
         * d -> f
         * e ->
         * f -> */

        /*
         * 0 -> 8, 1 ,5
         * 1 -> 0
         * 5 -> 0, 8
         * 8 -> 0, 5
         * 2 -> 3, 4
         * 3 -> 2 ,4
         * 4 -3 ,2 */
        GenericGraph<Integer> intGraph = new GenericGraph<Integer>();
/*        intGraph.addEdge(0, 8, false);
        intGraph.addEdge(0, 1, false);
        intGraph.addEdge(0, 5, false);

        intGraph.addEdge(1, 0, false);
        intGraph.addEdge(5, 0, false);
        intGraph.addEdge(5, 8, false);

        intGraph.addEdge(8, 0, false);
        intGraph.addEdge(8, 5, false);*/

        intGraph.addEdge(2, 3, false);
        intGraph.addEdge(2, 4, false);

        intGraph.addEdge(3, 2, false);
        intGraph.addEdge(3, 4, false);

        intGraph.addEdge(4, 3, false);
        intGraph.addEdge(4, 2, false);
        intGraph.addEdge(6, null, false);
        System.out.println(intGraph.getSize());


    }

    public void addVertex(T s) {
        map.put(s, new LinkedList<T>());
    }


    public void addEdge(T source,
                        T destination,
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

    public void dfs(T s) {
        Stack<T> stack = new Stack<>();
        stack.push(s);
        System.out.println("dfs");
        while (!stack.isEmpty()) {
            T current = stack.pop();
            System.out.println(current);
            if (current != null)
                for (T node : map.get(current)) {
                    stack.push(node);
                }
        }
    }

    public boolean haspathDfs(T s, T dest) {
        if (s == dest) {
            return true;
        }
        Stack<T> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            T current = stack.pop();
            if (current == dest) {
                return true;
            }
            if (current != null)
                for (T node : map.get(current)) {
                    stack.push(node);
                }
        }
        return false;
    }


    public boolean haspathDfsUndi(T s, T dest, Set<T> visited) {
        if (s == dest) {
            return true;
        }
        Stack<T> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            T current = stack.pop();
            if (!visited.contains(current)) {

                visited.add(current);
                if (current == dest) {
                    return true;
                }
                if (current != null)
                    for (T node : map.get(current)) {
                        stack.push(node);
                    }
            }
        }
        return false;
    }


    public boolean haspathDfsUndiRec(T s, T dest, Set<T> visited) {
        if (s == dest) {
            return true;
        }
        if (visited.contains(s)) {
            return false;
        }
        visited.add(s);

        for (T node : map.get(s)) {
            if (haspathDfsUndiRec(node, dest, visited)) {
                return true;
            }
        }
        return false;
    }

    public void dfsRec(T s) {
        System.out.println(s);
        for (T t : map.get(s)) {
            dfsRec(t);
        }
    }

    public void bfs(T s) {
        Queue<T> queue = new LinkedList<>();
        queue.add(s);
        System.out.println("bfs");
        while (!queue.isEmpty()) {
            T current = queue.poll();
            System.out.println(current);
            for (T key : map.get(current)) {
                queue.add(key);
            }
        }
    }

    public boolean hasPathBfs(T s, T dest) {
        if (s == dest) {
            return true;
        }
        Queue<T> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            T current = queue.poll();
            if (current == dest) {
                return true;
            }
            for (T key : map.get(current)) {
                queue.add(key);
            }
        }
        return false;
    }

    public int getCount() {
        int count = 0;
        Set<T> set = new HashSet<>();
        for (Map.Entry<T, List<T>> entry : map.entrySet()) {
            if (getCountUtil(entry.getKey(), set)) {
                count++;
            }
        }
        return count;
    }

    public int getSize() {

        int max = 0;
        Set<T> set = new HashSet<>();
        for (Map.Entry<T, List<T>> entry : map.entrySet()) {
            int count = getSizeUtil(entry.getKey(), set);
            max = Math.max(max, count);
        }

        return max;

    }

    public int getSizeUtil(T node, Set<T> visited) {
        if (visited.contains(node)) {
            return 0;
        }
        visited.add(node);
        int size = 1;
        for (T key : map.get(node)) {
            size += getSizeUtil(key, visited);
        }
        return size;
    }

    public boolean getCountUtil(T node, Set<T> visited) {
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);
        for (T key : map.get(node)) {
            getCountUtil(key, visited);
        }
        return true;
    }


    public static class Node<T> {
        public T value;
        public int count;

        public Node(T value, int count) {
            this.value = value;
            this.count = count;
        }
    }

}



