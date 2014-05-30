package live.graphs;

import java.awt.Graphics;

public class LiveGraph {
    private String xLabel, yLabel;
    private Graphics g;
    
    public LiveGraph(Graphics g, String xLabel, String yLabel) {
        this.g = g;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
    }
    
    public void push(double data) {
    }
}
