package linear;

import java.util.Comparator;
import java.util.Iterator;

public class SortedLinkedPriorityQueueExpt {
    public static void main(String[] args) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        SortedLinkedPriorityQueue<String> q = new SortedLinkedPriorityQueue<>(comparator);

        q.put("Hello");
        q.put("Nihao");
        q.put("Byebye");
        q.put("Name");
        q.put("AAAA");

        for (String str : q) {
            System.out.println(str);
        }
    }
}
