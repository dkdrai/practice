package neetcode.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {

  //920 · Meeting Rooms
  //https://www.lintcode.com/problem/920/
  public static class Interdata {

    int start, end;

    Interdata(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static boolean canAttendMeetings(List<Interdata> interdatas) {
    for (int i = 0; i < interdatas.size() - 1; i++) {
      if (interdatas.get(i).end > interdatas.get(i + 1).start) {
        return false;
      }
    }
    return true;
  }

  public static void main(String args[]) {
    List<Interdata> list = new ArrayList<>();
    Interdata iv = new Interdata(5, 8);
    list.add(iv);
    iv = new Interdata(9, 15);
    list.add(iv);
    iv = new Interdata(1, 4);
    list.add(iv);
    Comparator<Interdata> comparator = (o1, o2) -> o1.start < o2.start ? -1 : o1.start == o2.start ? 0 : 1;
    Collections.sort(list, comparator);
    for(Interdata data : list){
      System.out.println(data.start+" "+data.end);
    }
    System.out.println("output" + canAttendMeetings(list));
  }
}
