package graphics;

public class Vec2
{
  public static float distance(Vec2 p1, Vec2 p2)
  {
    float dx = p2.x - p1.x;
    float dy = p2.y - p1.y;

    return (float)Math.sqrt(dx * dx + dy * dy);
  }

  public float x;
  public float y;

  public Vec2()
  {
    // do nothing
  }

  public Vec2(float x, float y)
  {
    this.x = x;
    this.y = y;
  }

  public Vec2(Vec2 v)
  {
    this(v.x, v.y);
  }

  public Vec2 scale(float s)
	{
    x *= s;
    y *= s;
    return this;
	}

  public Vec2 add(Vec2 t)
	{
    x += t.x;
    y += t.y;
    return this;
	}

  public Vec2 sub(Vec2 t)
	{
    x -= t.x;
    y -= t.y;
    return this;
	}

  @Override
	public String toString()
	{
		return String.format("<%.2f,%.2f>", x, y);
	}

  public void print(String label)
  {
    System.out.println(label + toString());
  }

} // Vec2
