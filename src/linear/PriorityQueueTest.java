package linear;

import java.util.Comparator;
import java.util.Iterator;

public class PriorityQueueTest {
    public static void main(String[] args) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        PriorityQueue<String> q = new PriorityQueue<>(comparator);

        q.put("Hello");
        q.put("Nihao");
        q.put("Byebye");
        q.put("Name");
        q.put("AAAA");

        Iterator<String> itr = q.iterator();
        System.out.println(q.get());
        System.out.println(itr.next());
        System.out.println(itr.next());
        q.put("AAAA");
        System.out.println(q.get());
    }
}
