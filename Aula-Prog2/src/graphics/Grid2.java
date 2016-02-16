package graphics;

import util.*;

public class Grid2
{
  public static float fatFactor = 1.02f;

  public static class Cell
  {
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

    Cell(Vec2 p, Vec2 size)
    {
      bounds = new Bounds2(p, size);
    }

    private final Bounds2 bounds;
    final LinkedList<Vec2> points = new LinkedList<>();

  } // Cell

  public Grid2(final Bounds2 b, int nx, int ny)
  {
    bounds = new Bounds2(b).scale(fatFactor);
    cellSize = bounds.size();
    cellSize.x /= nx;
    cellSize.y /= ny;
    init(nx, ny);
  }

  public Grid2(final Bounds2 b, float h)
  {
    bounds = new Bounds2(b).scale(fatFactor);
    cellSize = new Vec2(h, h);

    Vec2 size = bounds.size();
    int nx = (int)Math.ceil(size.x / h);
    int ny = (int)Math.ceil(size.y / h);

    init (nx, ny);
  }

  public Grid2(final Vec2[] points, float h)
  {
    this(bounds(points), h);
    for (Vec2 p : points)
      getCell(p).points.add(p);
  }

  public final Int2 index(Vec2 p)
  {
    Vec2 p1 = bounds.getP1();
    int x = (int)((p.x - p1.x) / cellSize.x);
    int y = (int)((p.y - p1.y) / cellSize.y);

    return new Int2(x, y);
  }

  public final Bounds2 getBounds()
  {
    return new Bounds2(bounds);
  }

  public final Vec2 getCellSize()
  {
    return new Vec2(cellSize);
  }

  public final Int2 getDim()
  {
    return new Int2(dim);
  }

  public final Cell getCell(int x, int y)
  {
    return cells[x + y * dim.x];
  }

  public final Cell getCell(Int2 index)
  {
    return getCell(index.x, index.y);
  }

  public final Cell getCell(Vec2 p)
  {
    return getCell(index(p));
  }

  public final boolean hasCell(Int2 i)
  {
    return i.x >= 0 && i.x < dim.x && i.y >= 0 && i.y < dim.y;
  }

  public LinkedList findNeighbors(Vec2 p)
  {
    LinkedList<Vec2> neighbors = new LinkedList<>();
    float h = Math.max(cellSize.x, cellSize.y);
    Int2 cidx = index(p);

    for (int i = -1; i <= 1; i++)
    {
      int x = cidx.x + i;

      if (x < 0 || x >= dim.x)
        continue;
      for (int j = -1; j <= 1; j++)
      {
        int y = cidx.y + j;

        if (y < 0 || y >= dim.y)
          continue;
        // neighbors.addAll(getCell(x, y).points);
        for (Iterator<Vec2> pit = getCell(x, y).points.iterator(); pit.hasNext();)
        {
          Vec2 q = pit.next();

          if (Vec2.distance(p, q) <= h)
            neighbors.add(q);
        }
      }
    }
    return neighbors;
  }

  private static Bounds2 bounds(final Vec2[] points)
  {
    Bounds2 b = new Bounds2();

    for (Vec2 p : points)
      b.inflate(p);
    return b;
  }

  private final Bounds2 bounds;
  private final Vec2 cellSize;
  private Int2 dim;
  private Cell[] cells;

  private void init(int nx, int ny)
  {
    dim = new Int2(nx, ny);
    cells = new Cell[nx * ny];

    Vec2 p = bounds.getP1();
    float x1 = p.x;

    for (int i = 0, y = 0; y < ny; y++)
    {
      for (int x = 0; x < nx; x++, i++)
      {
        cells[i] = new Cell(p, cellSize);
        p.x += cellSize.x;
      }
      p.y += cellSize.y;
      p.x = x1;
    }
  }

} // Grid2
