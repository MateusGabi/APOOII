package figure2D;

public class Circle2D extends Shape2D
{
  public Circle2D(Point2D center, int radius)
  {
    this.center = center;
    this.radius = radius;
  }

  public Circle2D(int x, int y, int radius)
  {
    center = new Point2D(x, y);
    this.radius = radius;
  }

  @Override
  public void translate(Point2D t)
  {
    center.translate(t);
  }

  @Override
  public void print()
  {
    System.out.printf("**Circle %d\n", id);
    center.print("center");
    System.out.printf("radius: %d\n", radius);
  }

  private Point2D center;
  private int radius;

} // Circle2D
