import figure2D.*;

public class Figure2DTest
{
  public static void main(String[] args)
  {
    Figure2D f = new Figure2D();
 
    f.add(new Line2D(100, 100, 200, 200));
    f.add(new Circle2D(300, 300, 50));
    f.print();
  }

} // Figure2DTest
