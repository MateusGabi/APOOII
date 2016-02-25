
import util.*;

/**
 *
 * @author mateus gabi
 */
public class ArrayQueueTest {
    
    static void print(Queue<Integer> q)
    {
        for (Iterator<Integer> iterator = q.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String args[]) {
        Queue<Integer> fila = new ArrayQueue<>(10);

        try{
            int k = 0;
            while (k < 5) {
                fila.add(k);
            }      
        
        print(fila);
        }catch(RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
        
    }

}
