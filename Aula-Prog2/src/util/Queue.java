package util;

/**
 *
 * @author mateus gabi
 */
public interface Queue<E>
    extends Collection<E>{

    public E element();
    public boolean offer(E value);
    public E peek();
    public E poll();
    public E remove();    
    
}
