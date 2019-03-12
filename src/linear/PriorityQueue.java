package linear;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PriorityQueue<T> implements Iterable<T> {

    private class Node<T> {
        public T item;
        public Node<T> next;
        public Node<T> prev;
        public Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Comparator<T> comparator;
    private Node<T> head;

    public PriorityQueue(Comparator<T> aComparator) {
       this.comparator = aComparator;
       head = null;
    }

    public void put(T val) {
        Node<T> currNode = head;
        Node<T> prevNode = null;

        while (currNode != null && comparator.compare(val, currNode.item) >= 0) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        Node<T> newNode = new Node<>(val, prevNode, currNode);
        if (isEmpty()) {
            /* insert an empty node */
            head = newNode;
        } else if (currNode == null) {
            /* insert at the end of list */
            prevNode.next = newNode;
        } else if (prevNode == null) {
            /* insert at first pos */
            head = newNode;
            currNode.prev = newNode;
        } else {
            prevNode.next = newNode;
            currNode.prev = newNode;
        }
    }

    public T get() {
        if (isEmpty()) {
            return null;
        }

        Node<T> prevHead = head;
        head = head.next;

        /* unlink prevHead for GC */
        prevHead.next = null;
        if (head != null) head.prev = null;

       return prevHead.item;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return head.item;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return false;
    }

    public Iterator<T> iterator() {
        return new PriorityQueueIterator<T>(this);
    }

    public class PriorityQueueIterator<T> implements Iterator<T> {
        PriorityQueue<T> queue;
        PriorityQueue<T>.Node<T> currNode; // the next node to return
        PriorityQueue<T>.Node<T> lastReturn; // the node that return last time

        public PriorityQueueIterator(PriorityQueue<T> queue) {
            this.queue = queue;
            this.currNode = queue.head;
            lastReturn = null;
        }

        public T next() throws NoSuchElementException {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturn = currNode;
            currNode = currNode.next;
            return lastReturn.item;
        }

        public void remove() {
            if (lastReturn == null) {
               throw new IllegalStateException("No next has been called yet!");
            }

            PriorityQueue<T>.Node<T> lastReturnPrev = lastReturn.prev;
            PriorityQueue<T>.Node<T> lastReturnNext = lastReturn.next;

            unlinkNode(lastReturn);
            if (lastReturnPrev == null) {
                /* node is at the first */
                queue.head = lastReturnNext;
            } else {
                lastReturnPrev.next = lastReturnNext;
            }
            if (lastReturnNext != null) {
                lastReturnNext.prev = lastReturnPrev;
            }
        }

        private void unlinkNode(PriorityQueue<T>.Node<T> node) {
           if (node.prev != null) {
               node.prev.next = null;
           }

           if (node.next != null) {
               node.next.prev = null;
           }
        }

        public boolean hasNext() {
            return currNode != null;
        }
    }

    public Comparator<T> comparator() {
       return this.comparator;
    }
}