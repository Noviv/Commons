package live.components;

import java.awt.Component;
import java.awt.Graphics;

public abstract class LiveComponent extends Component {

    protected int x, y;
    protected final int width, height;

    public LiveComponent(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public abstract void paintComponent(Graphics g);
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setCoordinateLocation(int x, int y) {
        setX(x);
        setY(y);
    }
}
