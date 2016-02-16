public class IntVectorTest
{
  public static void main(String[] args)
  {
    IntVector a = new IntVector(new int[] {+3, 7, 8, 1});
    IntVector b = new IntVector(new int[] {-3, 5, 0, 4});

    a.print("a");
    b.print("b");
    System.out.printf("size(b): %d\n", b.size());
    a.add(b).add(a).add(b).print("2a+2b");
    a.add(b).mul(2).print("2a+2b");
    a.add(b.mul(2)).print("1a+2b");
  }

} // IntVectortest
