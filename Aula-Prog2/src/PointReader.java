import java.io.*;
import java.util.*;

import graphics.*;

public class PointReader {

    private static BufferedReader open(String fileName)
            throws FileNotFoundException {
        return new BufferedReader(new FileReader(fileName));
    }

    public List<Vec2> read(String fileName) {
        
        try (BufferedReader f = open(fileName)) {
            
            String line = f.readLine();            
            int n = Integer.parseInt(line);
            
            List<Vec2> points = new ArrayList<>(n);
            
            for (int i = 0; i < n; i++) {
                
                StringTokenizer st = new StringTokenizer(f.readLine());
                
                float x = Float.parseFloat(st.nextToken());                
                float y = Float.parseFloat(st.nextToken());
                
                points.add(new Vec2(x, y));
                
            }
            
            return points;
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static void main(String args[]) {
        List<Vec2> points = new PointReader().read(args[0]);
        
        for (Vec2 point : points) {
            System.out.printf(Locale.US, "%f %f\n", point.x, point.y);
        }
    }
}// POint Reader
