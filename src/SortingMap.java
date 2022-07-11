import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortingMap
{
public static void main(String[] args)

{
HashMap<Integer, String> map = new HashMap<>();

map.put(14, "Aayushi");
map.put(2, "Rachit");
map.put(30, "Amit");
map.put(5, "Anamika");

TreeMap<Integer, String> treeMap = new TreeMap<>(map);

System.out.println(treeMap);

    HashMap<Integer, String> unSortedMap = new HashMap<>();

    unSortedMap.put(14, "Aayushi");
    unSortedMap.put(20, "Rachit");
    unSortedMap.put(60, "Amit");
    unSortedMap.put(70, "Anamika");

    LinkedHashMap<Integer, String> sortedMap = new LinkedHashMap<>();

    unSortedMap.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

    System.out.println(sortedMap);
}
}