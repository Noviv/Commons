package fractal;

import java.awt.Color;
import java.awt.Graphics;

public final class BranchFractal {

    private BranchFractal() {
    }

    /**
     * Draw a new <code>BranchFractal</code>.
     *
     * @param g <code>Graphics</code> object to be draw onto.
     * @param x1 base x coordinate.
     * @param y1 base y coordinate.
     * @param angle The angle (degrees) that the tree will diverge at each
     * branch.
     * @param depth How many branches the tree will go.
     */
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

    /**
     * Draw a new <code>BranchFractal</code>.
     *
     * @param g <code>Graphics</code> object to be draw onto.
     * @param x1 base x coordinate.
     * @param y1 base y coordinate.
     * @param angle The angle (degrees) that the tree will diverge at each
     * branch.
     * @param depth How many branches the tree will go.
     * @param c The <code>Color</code> that the tree should be.
     */
    public static void drawTree(Graphics g, int x1, int y1, double angle, int depth, Color c) {
        g.setColor(c);
        drawTree(g, x1, y1, angle, depth);
    }
}
