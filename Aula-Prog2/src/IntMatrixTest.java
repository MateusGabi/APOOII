public class IntMatrixTest
{
  public static void main(String[] args)
  {
    IntMatrix a = new IntMatrix(2, 2, new int[] {+3, 7, 8, 1});
    IntMatrix b = new IntMatrix(2, 2, new int[] {-3, 5, 0, 4});
    IntVector c = new IntVector(new int[] {-3, 5});

    a.print("a");
    b.print("b");
    System.out.printf("size(b): %d\n", b.size());
    a.add(b).add(a).add(b).print("2a+2b");
    a.add(b).mul(2).print("2a+2b");
    a.add(b.mul(2)).print("1a+2b");
    a.mul(b).print("a*b");
    b.mul(c).print("b*c");
  }

} // IntMatrixtest
