package linear;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Queues implemented with arrays.
 *
 * @author Samuel A. Rebelsky
 * @author Zixuan Guo
 */
public class ArrayBasedQueue<T> implements Queue<T> {
    // +--------+----------------------------------------------------------
    // | Fields |
    // +--------+

    /**
     * The values stored in the queue.
     */
    T[] values;

    /**
     * The index of the front of the queue.
     */
    int front;

    /**
     * The number of elements in the queue.
     */
    int size;

    // +--------------+----------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * Create a new queue that holds up to capacity elements.
     */
    @SuppressWarnings({"unchecked"})
    // Handle array casting
    public ArrayBasedQueue(int capacity) throws Exception {
        if (capacity <= 0) {
            throw new Exception("Queues must have a positive capacity.");
        } // if (capacity <= 0)
        // Yay Java! It's not possible to say new T[capacity], so
        // we use this hack.
        this.values = (T[]) new Object[capacity];
        this.front = 0;
        this.size = 0;
    } // ArayBasedQueue(int capacity)

    // +---------------+---------------------------------------------------
    // | Queue Methods |
    // +---------------+

    @Override public boolean isEmpty() {
        return this.size <= 0;
    } // isEmpty()

    @Override public boolean isFull() {
        return this.size >= this.values.length;
    } // isFull()

    @Override public void put(T val) throws Exception {
        if (this.isFull()) {
            T[] newArray = (T[]) new Object[values.length * 2];
            Iterator<T> iterator = iterator();
            for (int i = 0; i < size; i++) {
                newArray[i] = iterator.next();
            }
            this.front = 0;
            this.size = values.length;
            this.values = newArray;
        } // this.isFull()
        this.values[this.back()] = val;
        ++this.size;
    } // put(T)

    @Override public T get() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("empty");
        } // if empty
        // Grab and clear the element at the front of the queue
        T result = this.values[this.front];
        this.values[this.front] = null;
        this.front = (this.front + 1) % this.values.length;
        // We're removing an element, so decrement the size
        --this.size;
        // And we're done
        return result;
    } // get(T)

    @Override public T peek() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("empty");
        } // if empty
        return this.values[this.front];
    } // peek()

    @Override public T dequeue() throws Exception {
        return this.get();
    } // dequeue

    @Override public void enqueue(T val) throws Exception {
        this.put(val);
    } // enqueue

    @Override public Iterator<T> iterator() {
        return new Iterator<T>() {
            int pos = 0;

            @Override public boolean hasNext() {
                return pos < size;
            }

            @Override public T next() {
                T val = values[(front + pos) % values.length];
                pos += 1;
                return val;
            }

            @Override public void remove() {
                if (pos == 0) {
                    throw new IllegalStateException("No next has been called yet!");
                }
                int index;
                for (index = pos; index < size; index++) {
                    values[(front + index - 1) % values.length] = values[(front + index) % values.length];
                }
                values[(front + index - 1) % values.length] = null;
                size--;
            } // remove
        }; // new Iterator<T>()
    } // iterator()

    // +----------------+--------------------------------------------------
    // | Helper Methods |
    // +----------------+

    /**
     * Get the index of the back of the queue. The back is where we add the next element.
     */
    private int back() {
        return (this.front + this.size) % this.values.length;
    } // back()

} // class ArrayBasedQueue<T>
