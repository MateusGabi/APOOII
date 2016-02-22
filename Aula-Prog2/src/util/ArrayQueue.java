package util;

/**
 *
 * @author mateus gabi
 */
public class ArrayQueue<E>
        implements Queue<E> {

    public ArrayQueue(int n) {
        if (n < 2) {
            throw new IllegalStateException();
        }
        data = new Object[n];
        head = tail = 0;
    }

    @Override
    public E element() {
        E value = peek();

        if (value == null) {
            throw new NoSuchElementException("Queue is empty.");
        }

        return value;
    }

    @Override
    public boolean offer(E value) {
        int i = (tail + 1) % data.length;

        if (i == head) {
            return false;
        }
        data[tail = i] = value;
        size++;
        return true;
    }

    @Override
    public E peek() {

        return isEmpty() ? null : (E) data[(head + 1) % data.length];
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        size--;
        return (E) data[head = (head + 1) % data.length];
    }

    @Override
    public E remove() {
        E value = poll();

        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }

    @Override
    public void add(E value) {
        if (!offer(value)) {
            throw new IllegalStateException();
        }
    }

    @Override
    public void addAll(Collection<? extends E> c) {
        for (Iterator<? extends E> iterator = c.iterator(); iterator.hasNext();) {
            add(iterator.next());
        }
    }

    @Override
    public boolean remove(E value) {
        return false;
    }

    @Override
    public void clear() {
        size = head = tail = 0;
    }

    @Override
    public boolean contains(E value) {
        for (int i = head; i != tail;) {            
            if (data[i = (i+1) % data.length].equals(value)) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int head;
    int tail;
    int size;
    Object[] data;
}
