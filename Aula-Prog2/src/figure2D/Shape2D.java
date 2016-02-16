package figure2D;

public abstract class Shape2D
{
  public Color color = Color.blue;

  public abstract void translate(Point2D t);
  public abstract void print();

  int id = -1;

} // Shape2D
