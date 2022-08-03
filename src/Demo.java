import java.util.*;

public class Demo {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        List<List<Integer>> list = new ArrayList<>();
        Integer array1[] = {17, -1, -1};
        Integer array2[] = {15, 13, 17};
        Integer array3[] = {7, -1, -1};
        Integer array4[] = {13, -1, -1};
        Integer array6[] = {5, 3, 7};
        Integer array7[] = {3, -1, -1};
        Integer array8[] = {10, 5, 15};

        list.addAll(Collections.singleton(Arrays.asList(array1)));
        list.addAll(Collections.singleton(Arrays.asList(array2)));
        list.addAll(Collections.singleton(Arrays.asList(array3)));
        list.addAll(Collections.singleton(Arrays.asList(array4)));
        list.addAll(Collections.singleton(Arrays.asList(array6)));
        list.addAll(Collections.singleton(Arrays.asList(array7)));
        list.addAll(Collections.singleton(Arrays.asList(array8)));

        System.out.println(findRoot(list));


    }

    public static int findRoot(List<List<Integer>> nodes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nodes.size(); i++) {
            map.put(nodes.get(i).get(0), nodes.get(i));
        }
        for (int i = 0; i < nodes.size(); i++) {
            List<Integer> list = map.get(nodes.get(i).get(0));
            if(map.size() == 1){
                return map.entrySet().iterator().next().getKey();
            }
            if (list != null && list.get(1) != -1 && list.get(2) != -1) {
                removeChild(list, map);
            }
        }
        if (map.size() == 1) {
            return map.entrySet().iterator().next().getKey();
        }
        return -1;
    }

    public static void removeChild(List<Integer> list, Map<Integer, List<Integer>> map) {
        if (list == null) {
            return;
        }
        if (list.get(1) != -1) {
            removeChild(map.get(list.get(1)), map);
        }
        if (list.get(2) != -1) {
            removeChild(map.get(list.get(2)), map);
        }
        map.remove(list.get(0));
    }
}

