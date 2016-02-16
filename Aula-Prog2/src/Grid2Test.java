import graphics.*;

public class Grid2Test
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
    Vec2[] points = rand(100, -20, 30);
    Grid2 grid = new Grid2(points, 6);

    grid.getBounds().print("**Grid bounds: ");
    new Grid2Viewer(grid, points);
  }

} // Grid2Test
