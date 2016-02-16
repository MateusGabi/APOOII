package figure2D;

public class Point2D
{
  public int x;
  public int y;

  public Point2D()
  {
    // do nothing
  }

  public Point2D(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public void translate(Point2D t)
  {
    x += t.x;
    y += t.y;
  }

  public void print(String name)
  {
    System.out.printf("%s<%d,%d>\n", name, x, y);
  }

} // Point2D
