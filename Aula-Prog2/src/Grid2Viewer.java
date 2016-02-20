//import java.awt.geom.*;
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//
//import graphics.*;
//import util.*;
//
//public class Grid2Viewer
//  extends JFrame
//{
//	public Grid2Viewer(Grid2 grid, Vec2[] points)
//	{
//		super("Grid2 Viewer");
//		getContentPane().setLayout(new BorderLayout());
//		getContentPane().add(new Grid2Panel(grid, points), BorderLayout.CENTER);
//		setSize(640, 480);
//		addWindowListener(new WindowAdapter()
//		{
//			@Override
//			public void windowClosing(WindowEvent e)
//			{
//				System.exit(0);
//			}
//		});
//		setVisible(true);
//		toFront();
//	}
//
//	private final static class Grid2Panel
//    extends Canvas
//	{
//		public Grid2Panel(Grid2 grid, Vec2[] points)
//		{
//			this.grid = grid;
//      this.points = points;
//
//      Bounds2 b = grid.getBounds();
//
//      size = b.size();
//      center = b.center();
//			setBackground(Color.WHITE);
//			addKeyListener(new KeyAdapter()
//			{
//				@Override
//				public void keyPressed(KeyEvent e)
//				{
//					switch (e.getKeyCode())
//					{
//						case KeyEvent.VK_ADD:
//							zoomFactor *= 1.2;
//							repaint();
//							break;
//
//						case KeyEvent.VK_SUBTRACT:
//							zoomFactor /= 1.2;
//							repaint();
//							break;
//					}
//				}
//			});
//      addMouseListener(new MouseAdapter()
//      {
//				@Override
//        public void mouseClicked(MouseEvent e)
//        {
//          Vec2 p = screenToWorld(e.getPoint());
//          Int2 i = grid.index(p);
//
//          if (grid.hasCell(i) && grid.getCell(i).contains(p))
//          {
//            cidx = i;
//            neighbors = grid.findNeighbors(cp = p);
//            repaint();
//          }
//        }
//      });
//		}
//
//    @Override
//		public void paint(Graphics g)
//		{
//      Rectangle r = getBounds();
//
//      scale = (float)Math.min(r.getWidth() / size.x, r.getHeight() / size.y);
//      scale *= zoomFactor;
//
//      Vec2 c = (new Vec2(center)).scale(scale);
//
//      offset.x = (float)r.getCenterX() - c.x;
//      offset.y = (float)r.getCenterY() - c.y;
//
//      Graphics2D g2 = (Graphics2D)g;
//      Int2 dim = grid.getDim();
//
//			for (int y = 0; y < dim.y; y++)
//        for (int x = 0; x < dim.x; x++)
//        {
//          Grid2.Cell cell = grid.getCell(x, y);
//          Shape s = getShape(cell.getBounds());
//
//          if (cidx.x == x && cidx.y == y)
//            g2.setColor(Color.LIGHT_GRAY);
//          else
//            g2.setColor(cell.isEmpty() ? Color.GREEN : Color.ORANGE);
//          g2.fill(s);
//          g2.setColor(Color.BLACK);
//          g2.draw(s);
//        }
//
//      Shape s = getShape(grid.getBounds());
//
//      g2.setColor(Color.RED);
//      g2.setStroke(new BasicStroke(2));
//      g2.draw(s);
//			drawPoints(g2, Color.BLACK);
//      if (cp != null)
//      {
//        drawNeighbors(g2);
//        g2.setColor(Color.MAGENTA);
//        drawPoint(g2, cp);
//      }
//		}
//
//		private final Grid2 grid;
//    private final Vec2[] points;
//    private LinkedList neighbors;
//    private final Vec2 size, center, offset = new Vec2();
//    private float scale, zoomFactor = 1;
//    private Int2 cidx = new Int2(-1, -1);
//    private Vec2 cp;
//
//    private Vec2 screenToWorld(Point p)
//    {
//      return (new Vec2(p.x, p.y)).sub(offset).scale(1 / scale);
//    }
//
//    private Vec2 transform(Vec2 p)
//    {
//      return p.scale(scale).add(offset);
//    }
//
//    private Shape getShape(Bounds2 b)
//		{
//			Vec2 p1 = transform(b.getP1());
//			Vec2 s = b.size().scale(scale);
//
//			return new Rectangle2D.Float(p1.x, p1.y, s.x, s.y);
//		}
//
//		private Shape getShape(Vec2 p)
//		{
//      p = transform(new Vec2(p));
//			return new Ellipse2D.Float(p.x - 3, p.y - 3, 6, 6);
//		}
//
//		private void drawPoints(Graphics2D g2, Color color)
//		{
//			g2.setColor(color);
//			for (Vec2 p : points)
//				drawPoint(g2, p);
//		}
//
//    private void drawPoint(Graphics2D g2, Vec2 p)
//    {
//      g2.fill(getShape(p));
//    }
//
//    private Shape getShape(Vec2 center, Vec2 size)
//    {
//      Vec2 s = size.scale(scale);
//      Vec2 p = transform(new Vec2(center));
//
//      return new Ellipse2D.Float(p.x - s.x, p.y - s.y, s.x * 2, s.y * 2);
//    }
//
//    private void drawNeighbors(Graphics2D g2)
//    {
//			g2.setPaint(new Color(0, 0, 1, 0.25f));
//      g2.fill(getShape(cp, grid.getCellSize()));
//			g2.setColor(Color.WHITE);
//			for (util.Iterator<Vec2> i = neighbors.iterator(); i.hasNext();)
//				drawPoint(g2, i.next());
//    }
//
//  } // Grid2Panel
//
//} // Grid2Viewer
