package graphics;

import util.*;

class QuadtreeIterator
  implements util.Iterator<Quadtree.Node>
{
  QuadtreeIterator(Quadtree.Node root)
  {
    stack = new ArrayStack<>();
    stack.push(root);
  }

  @Override
  public boolean hasNext()
  {
    return !stack.empty();
  }

  @Override
  public Quadtree.Node next()
  {
    Quadtree.Node node = stack.pop();

    if (!node.isLeaf())
      for (int i = 4; i > 0;)
        stack.push(node.children[--i]);
    return node;
  }

  private final util.Stack<Quadtree.Node> stack;

} // QuadtreeIterator

public class Quadtree
  implements util.Iterable<Quadtree.Node>
{
  public static float fatFactor = 1.02f;

  @Override
  public Iterator<Node> iterator()
  {
    return new QuadtreeIterator(root);
  }

  public static class Node
  {
    public final boolean isLeaf()
    {
      return children == null;
    }

    public final Bounds2 getBounds()
    {
      return new Bounds2(bounds);
    }

    public final boolean contains(Vec2 p)
    {
      return bounds.contains(p);
    }

    public final boolean isEmpty()
    {
      return points.isEmpty();
    }

    public final int getPointCount()
    {
      return points.size();
    }

    public final String getId()
    {
      return id;
    }

    Node(Bounds2 b)
    {
      bounds = new Bounds2(b);
    }

    Node(Vec2 p, Vec2 size)
    {
      bounds = new Bounds2(p, size);
    }

    private final Bounds2 bounds;
    final LinkedList<Vec2> points = new LinkedList<>();
    Node[] children;
    String id;

  } // Node

  public static int maxNodePoints = 5;

  public Quadtree(final Bounds2 b)
  {
    bounds = new Bounds2(b).scale(fatFactor);
    (root = new Node(bounds)).id = "";
  }

  public Quadtree(final Vec2[] points)
  {
    this(bounds(points));
    for (Vec2 p : points)
      root.points.add(p);
    split(root);
  }

  private static void split(Node node)
  {
    if (node.points.size() <= maxNodePoints)
      return;

    Vec2 s = node.bounds.size().scale(0.5f);
    Vec2 p = node.bounds.getP1();

    node.children = new Node[4];
    node.children[0] = new Node(p, s);
    node.children[1] = new Node(new Vec2(p.x + s.x, p.y), s);
    node.children[2] = new Node(new Vec2(p.x + s.x, p.y + s.y), s);
    node.children[3] = new Node(new Vec2(p.x, p.y + s.y), s);
    for (Iterator<Vec2> pit = node.points.iterator(); pit.hasNext();)
    {
      p = pit.next();
      for (int i = 0; i < 4; i++)
        if (node.children[i].contains(p))
          node.children[i].points.add(p);
    }
    node.points.clear();
    for (int i = 0; i < 4; i++)
    {
      node.children[i].id = node.id + i;
      split(node.children[i]);
    }
  }

  public final void print()
  {
    print(root);
  }

  private static void print(Node node)
  {
    if (node.isLeaf())
    {
      int np = node.points.size();

      System.out.printf(
        "%s: %s\n",
        node.id,
        np == 0 ? "empty" : String.valueOf(np));
      return;
    }
    for (int i = 0; i < 4; i++)
      print(node.children[i]);
  }

  public final Bounds2 getBounds()
  {
    return new Bounds2(bounds);
  }

  private static Bounds2 bounds(final Vec2[] points)
  {
    Bounds2 b = new Bounds2();

    for (Vec2 p : points)
      b.inflate(p);
    return b;
  }

  private final Bounds2 bounds;
  private Node root;

  public int getPointCount()
  {
    return getPointCount(root);
  }

  private static int getPointCount(Node node)
  {
    if (node.isLeaf())
      return node.points.size();

    int count = 0;

    for (int i = 0; i < 4; i++)
      count += getPointCount(node.children[i]);
    return count;
  }

} // Quadtree
