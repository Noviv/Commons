package fractal;

import java.awt.Color;
import java.awt.Graphics;

public final class BranchFractal {
    
    private BranchFractal() {
    }
    
    public static void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0) {
            return;
        }
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);
        g.drawLine(x1, y1, x2, y2);
        drawTree(g, x2, y2, angle - 20, depth - 1);
        drawTree(g, x2, y2, angle + 20, depth - 1);
    }
    
    public static void drawTree(Graphics g, int x1, int y1, double angle, int depth, Color c) {
        g.setColor(c);
        drawTree(g, x1, y1, angle, depth);
    }
}
