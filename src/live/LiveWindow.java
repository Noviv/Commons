package live;

import live.exceptions.CreationException;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import live.components.LiveComponent;
import data.datastructures.GenericKeyVal;

public class LiveWindow extends JFrame implements KeyListener, MouseListener, MouseMotionListener {

    private final ArrayList<LiveComponent> livecomps;
    private boolean mousePressed = false;
    private final GenericKeyVal<LiveComponent, Point> componentMovementTracker;

    public LiveWindow(int width, int height, boolean minimized, String title) {
        livecomps = new ArrayList<>();
        componentMovementTracker = new GenericKeyVal();

        this.setSize(width, height);
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void add(LiveComponent lc) {
        this.add((Component) lc);
        livecomps.add(lc);
    }

    public void remove(LiveComponent lc) throws CreationException {
        if (livecomps.contains(lc)) {
            livecomps.remove(lc);
        } else {
            throw CreationException.DOES_NOT_EXIST_EXCEP;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (LiveComponent lc : livecomps) {
            if (lc.contains(e.getPoint())) {
                componentMovementTracker.setA(lc);
                componentMovementTracker.setB(e.getPoint());
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mousePressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (mousePressed) {
            livecomps.get(livecomps.indexOf(componentMovementTracker.a)).setCoordinateLocation(componentMovementTracker.b.x, componentMovementTracker.b.y);
        }
    }
}
