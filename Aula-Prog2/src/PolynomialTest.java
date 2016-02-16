import math.*;
import util.*;

public class PolynomialTest
{
  static void print(String label, Polynomial p)
  {
    System.out.printf("%s(x)=", label);
    if (p.isZero())
      System.out.println("0");
    else
    {
      for (Iterator i = p.iterator(); i.hasNext();)
        System.out.print(i.next());
      System.out.println();
    }
  }

  static Polynomial.Term term(float c, int e)
  {
    return new Polynomial.Term(c, e);
  }

  public static void main(String[] args)
  {
    Polynomial p1 = new Polynomial();

    p1.add(term(1, 2))
      .add(term(4, 0))
      .add(term(1, 5))
      .add(term(2, 3))
      .add(term(3, 1));
    print("p1", p1);

    Polynomial p2 = new Polynomial(p1);
 
    p2.add(term(-2, 3))
      .add(term(-4, 0))
      .add(term(-1, 5));
    print("p2", p2);
    print("p1+p2", Polynomial.add(p1, p2));
  }

} // PolynomialTest
