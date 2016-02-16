package util;

/**
 *
 * @author Pagliosa
 * @param <E>
 */
public class ArrayStack<E>
        extends Array<E>
        implements Stack<E> {

    @Override
    public void push(E value) {
        add(value);
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return (E) data[size -= 1];
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return (E) data[size - 1];
    }

    @Override
    public boolean empty() {
        return isEmpty();
    }

} // ArrayStack
