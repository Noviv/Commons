package live.components;

import java.awt.Graphics;
import javax.swing.JLabel;

public class LiveLabel extends LiveComponent {

    private JLabel value;
    private String key;
    private int keyX , keyY;

    public LiveLabel(int x, int y, int width, int height, String key, String value) {
        super(x, y, width, height);
        this.key = key;
        keyX = x + (10 * key.length());
        keyY = y - 10;
        this.value = new JLabel(value);
    }

    @Override
    public void paintComponent(Graphics g) {
        value.paint(g);
        g.drawString(key, super.x - (10 * key.length()), super.y - 10);
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value.setText(value);
    }
    
    @Override
    public void setX(int x) {
        this.x = x;
        keyX = x + (10 * key.length());
    }
    
    @Override
    public void setY(int y) {
        this.y = y;
        keyY = y - 10;
    }
}
