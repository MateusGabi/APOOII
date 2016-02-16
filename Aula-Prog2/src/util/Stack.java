package util;

public interface Stack<E>
  extends Iterable<E>
{
    /**
     * Tests if this stack is empty.
     * @return 
     */
  public boolean empty();
  /**
   * Looks at the object at the top of this stack without removing it from the stack.
   * @return 
   */
  public E peek();
  /**
   * Removes the object at the top of this stack and returns that object as the value of this function.
   * @return 
   */
  public E pop();
  /**
   * Pushes an item onto the top of this stack.
   * @param value 
   */
  public void push(E value);

} // Stack
