package graphics;

public class Bounds2
{
  public Bounds2()
  {
    p1 = new Vec2(+Float.MAX_VALUE, +Float.MAX_VALUE);
    p2 = new Vec2(-Float.MAX_VALUE, -Float.MAX_VALUE);
  }

  public Bounds2(Vec2 p, Vec2 size)
  {
    p1 = new Vec2(p);
    p2 = new Vec2(p.x + size.x, p.y + size.y);
  }

  public Bounds2(Bounds2 b)
  {
    p1 = new Vec2(b.p1);
    p2 = new Vec2(b.p2);
  }

  public Vec2 getP1()
  {
    return new Vec2(p1);
  }

  public Vec2 getP2()
  {
    return new Vec2(p2);
  }

  public void inflate(float x, float y)
  {
    if (x < p1.x)
      p1.x = x;
    if (y < p1.y)
      p1.y = y;
    if (x > p2.x)
      p2.x = x;
    if (y > p2.y)
      p2.y = y;
  }

  public void inflate(Vec2 p)
  {
    inflate(p.x, p.y);
  }

  public Vec2 center()
  {
    return new Vec2((p1.x + p2.x) * 0.5f, (p1.y + p2.y) * 0.5f);
  }

  public Bounds2 scale(float s)
  {
    Vec2 t = center().scale(1 - s);

    p1.x = p1.x * s + t.x;
    p1.y = p1.y * s + t.y;
    p2.x = p2.x * s + t.x;
    p2.y = p2.y * s + t.y;
    return this;
  }

  public Vec2 size()
  {
    return new Vec2(p2.x - p1.x, p2.y - p1.y);
  }

  public boolean contains(Vec2 p)
	{
		return p1.x <= p.x && p2.x >= p.x && p1.y <= p.y && p2.y >= p.y;
	}

	@Override
	public String toString()
	{
		return String.format("p1%s p2%s", p1.toString(), p2.toString());
	}

  public void print(String label)
  {
    System.out.println(label + toString());
  }

  private final Vec2 p1;
  private final Vec2 p2;

} // Bounds2
