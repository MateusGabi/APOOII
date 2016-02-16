import graphics.*;

public class QuadtreeTest
{
  public static Vec2[] rand(int n, float min, float max)
  {
    Vec2[] points = new Vec2[n];
    float d = max - min;

    for (int i = 0; i < n; i++)
    {
      float x = min + (float)Math.random() * d;
      float y = min + (float)Math.random() * d;

      points[i] = new Vec2(x, y);
    }
    return points;
  }

  public static void main(String[] args)
  {
    Vec2[] points = rand(50, -20, 30);
    Quadtree tree = new Quadtree(points);

    tree.print();
    System.out.printf("Point count: %d\n", tree.getPointCount());
    for (util.Iterator<Quadtree.Node> nit = tree.iterator(); nit.hasNext();)
    {
      Quadtree.Node node = nit.next();

      if (node.getId().isEmpty())
        continue;

      int np = node.getPointCount();

      System.out.printf(
        "%s: %s\n",
        node.getId(),
        np == 0 ? "empty" : String.valueOf(np));
    }
  }

} // QuadtreeTest
