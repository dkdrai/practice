package neetcode.binarysearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeBasedKeyvalueStore {

  private Map<String, TreeMap<Integer,String>> map;

  //981. Time Based Key-value Store
  //https://leetcode.com/problems/time-based-key-value-store/
  /** Initialize your data structure here. */
  public TimeBasedKeyvalueStore() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if(!map.containsKey(key)) {
      map.put(key,new TreeMap<>());
    }
    map.get(key).put(timestamp,value);
  }

  public String get(String key, int timestamp) {
    TreeMap<Integer,String> treeMap = map.get(key);
    if(treeMap==null) {
      return "";
    }
    Integer floor = treeMap.floorKey(timestamp);
    if(floor==null) {
      return "";
    }
    return treeMap.get(floor);
  }
}
