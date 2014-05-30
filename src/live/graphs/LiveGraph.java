package live.graphs;

import java.awt.Graphics;

public class LiveGraph {
    private String xLabel, yLabel;
    private Graphics g;
    private int x, y;
    
    public LiveGraph(Graphics g, int x, int y, String xLabel, String yLabel) {
        this.g = g;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.x = x;
        this.y = y;
    }
    
    public void push(double data) {
        x += 10;
    }
}
