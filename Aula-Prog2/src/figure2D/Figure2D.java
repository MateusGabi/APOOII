package figure2D;

public class Figure2D
{
  public Figure2D()
  {
    shapes = new Shape2D[10];
  }

  public int add(Shape2D shape)
  {
    if (count == shapes.length)
      resize();
    shapes[count++] = shape;
    return shape.id = ++nextId;
  }

  public boolean remove(int id)
  {
    int i = find(id);

    if (i == -1)
      return false;
    while (++i < count)
      shapes[i - 1] = shapes[i];
    count--;
    return true;
  }

  public void clear()
  {
    count = 0;
  }

  public boolean isEmpty()
  {
    return count == 0;
  }

  public int size()
  {
    return count;
  }

  public void translate(Point2D t)
  {
    for (int i = 0; i < count; i++)
      shapes[i].translate(t);
  }

  public void translate(int tx, int ty)
  {
    translate(new Point2D(tx, ty));
  }

  public void print()
  {
    for (int i = 0; i < count; i++)
      shapes[i].print();
  }

  private Shape2D[] shapes;
  private int count;
  private int nextId = -1;

  private void resize()
  {
    Shape2D[] temp = new Shape2D[shapes.length * 2];

    for (int i = 0; i < shapes.length; i++)
      temp[i] = shapes[i];
    shapes = temp;
  }

  private int find(int id)
  {
    for (int i = 0; i < count; i++)
      if (shapes[i].id == id)
        return i;
    return -1;
  }

} // FIgure2D
