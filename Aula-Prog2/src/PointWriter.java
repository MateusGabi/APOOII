
import java.io.*;
import java.util.*;

import graphics.*;

public class PointWriter {

    private static PrintWriter open(String fileName)
            throws IOException {
        return new PrintWriter(new FileWriter(fileName));
    }

    public void write(String fileName, Collection<Vec2> c)
            throws IOException {

        try (PrintWriter f = open(fileName)) {
            f.println(c.size());

            for (Vec2 p : c) {
                f.printf(Locale.US, "5f %f\n", p.x, p.y);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) throws IOException {
        List<Vec2> points = new ArrayList<>(10);

        for (int i = 1; i <= 10; i++) {
            points.add(new Vec2(i, i));
        }

        new PointWriter().write(args[0], points);
    }
} // PointWriter
