package figure2D;

public class Line2D extends Shape2D
{
  public Line2D(Point2D p1, Point2D p2)
  {
    this.p1 = p1;
    this.p2 = p2;
  }

  public Line2D(int x1, int y1, int x2, int y2)
  {
    p1 = new Point2D(x1, y1);
    p2 = new Point2D(x2, y2);
  }

  @Override
  public void translate(Point2D t)
  {
    p1.translate(t);
    p2.translate(t);
  }

  @Override
  public void print()
  {
    System.out.printf("**Line %d\n", id);
    p1.print("p1");
    p1.print("p2");
  }

  private Point2D p1;
  private Point2D p2;

} // Line2D
