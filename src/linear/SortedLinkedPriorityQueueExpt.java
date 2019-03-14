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

        System.out.println("isEmpty? " + q.isEmpty());
        
        q.put("Hello");
        q.put("Nihao");
        q.put("Byebye");
        q.put("Name");
        q.put("AAAA");

        
        /* iterate all the element */
        System.out.println("Print all elements");
        for (String str : q) {
            System.out.println(str);
        }
        System.out.println();
        
        /* remove one of the element */
        System.out.println("remove Byebye");
        Iterator<String> itr = q.iterator();
        while (itr.hasNext()) {
          String str = itr.next();
          if (str.equals("Byebye")) {
            itr.remove();
          }
        }
        System.out.println();
        
        /* iterate again */
        System.out.println("Print all element again");
        for (String str : q) {
            System.out.println(str);
        }
        System.out.println();
        
        /* test peek */
        System.out.println("test peek");
        System.out.println(q.peek());
        System.out.println();
        
        /* test get */
        System.out.println("test get");
        while (!q.isEmpty()) {
          System.out.println(q.get());
        }
        System.out.println();
        
        /* should be empty */
        System.out.println("Empty? " + q.isEmpty());
    }
}
