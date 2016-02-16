package figure2D;

public class Color
{
  public int r;
  public int g;
  public int b;

  public Color()
  {
    // do nothing
  }

  public Color(int r, int g, int b)
  {
    this.r = r;
    this.g = g;
    this.b = b;
  }
  
  public static final Color red = new Color(255, 0, 0);
  public static final Color green = new Color(0, 255, 0);
  public static final Color blue = new Color(0, 0, 255);

} // Color
