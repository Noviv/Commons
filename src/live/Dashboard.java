package live;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Dashboard extends javax.swing.JFrame {
    
    public static void main(String[] args) throws Exception {
        Dashboard d = new Dashboard("Test Dashboard", 2);
        d.putValue("pKValFwd", (Number) 10, "pwds");
    }

    public static ArrayList<Integer> ids = new ArrayList<>();
    
    private ComponentMover cm;
    private HashMap<Object, Number> values;

    public Dashboard(String name, int ID) throws DashboardException {
        if (ids.contains(ID)) {
            throw DashboardException.ID_ALREADY_EXISTS;
        }
        
        cm = new ComponentMover();
        values = new HashMap<>();
        
        initComponents();
        setTitle(name + " - " + ID);
        setVisible(true);

        ids.add(ID);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

    public void putValue(String name, Number n, String unit) {
        JLabel label = new JLabel(name + ": " + n + unit);
        cm.registerComponent(label);
        panel.add(label);
        panel.repaint();
        System.out.println("ran");
    }

    private final class ComponentMover extends MouseAdapter {

        private Insets dragInsets = new Insets(0, 0, 0, 0);
        private Dimension snapSize = new Dimension(1, 1);
        private Insets edgeInsets = new Insets(0, 0, 0, 0);
        private boolean changeCursor = true;
        private boolean autoLayout = false;

        private Class destinationClass;
        private Component destinationComponent;
        private Component destination;
        private Component source;

        private Point pressed;
        private Point location;

        private Cursor originalCursor;
        private boolean autoscrolls;
        private boolean potentialDrag;
        
        public ComponentMover() {
        }

        public ComponentMover(Class destinationClass, Component... components) {
            this.destinationClass = destinationClass;
            registerComponent(components);
        }

        public ComponentMover(Component destinationComponent, Component... components) {
            this.destinationComponent = destinationComponent;
            registerComponent(components);
        }

        public boolean isAutoLayout() {
            return autoLayout;
        }

        public void setAutoLayout(boolean autoLayout) {
            this.autoLayout = autoLayout;
        }

        public boolean isChangeCursor() {
            return changeCursor;
        }

        public void setChangeCursor(boolean changeCursor) {
            this.changeCursor = changeCursor;
        }

        public Insets getDragInsets() {
            return dragInsets;
        }

        public void setDragInsets(Insets dragInsets) {
            this.dragInsets = dragInsets;
        }

        public Insets getEdgeInsets() {
            return edgeInsets;
        }

        public void setEdgeInsets(Insets edgeInsets) {
            this.edgeInsets = edgeInsets;
        }

        public void deregisterComponent(Component... components) {
            for (Component component : components) {
                component.removeMouseListener(this);
            }
        }

        public void registerComponent(Component... components) {
            for (Component component : components) {
                component.addMouseListener(this);
            }
        }

        public Dimension getSnapSize() {
            return snapSize;
        }

        public void setSnapSize(Dimension snapSize) {
            if (snapSize.width < 1
                    || snapSize.height < 1) {
                throw new IllegalArgumentException("Snap sizes must be greater than 0");
            }

            this.snapSize = snapSize;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            source = e.getComponent();
            int width = source.getSize().width - dragInsets.left - dragInsets.right;
            int height = source.getSize().height - dragInsets.top - dragInsets.bottom;
            Rectangle r = new Rectangle(dragInsets.left, dragInsets.top, width, height);

            if (r.contains(e.getPoint())) {
                setupForDragging(e);
            }
        }

        private void setupForDragging(MouseEvent e) {
            source.addMouseMotionListener(this);
            potentialDrag = true;

            if (destinationComponent != null) {
                destination = destinationComponent;
            } else if (destinationClass == null) {
                destination = source;
            } else {
                destination = SwingUtilities.getAncestorOfClass(destinationClass, source);
            }

            pressed = e.getLocationOnScreen();
            location = destination.getLocation();

            if (changeCursor) {
                originalCursor = source.getCursor();
                source.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
            }

            if (destination instanceof JComponent) {
                JComponent jc = (JComponent) destination;
                autoscrolls = jc.getAutoscrolls();
                jc.setAutoscrolls(false);
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Point dragged = e.getLocationOnScreen();
            int dragX = getDragDistance(dragged.x, pressed.x, snapSize.width);
            int dragY = getDragDistance(dragged.y, pressed.y, snapSize.height);

            int locationX = location.x + dragX;
            int locationY = location.y + dragY;

            while (locationX < edgeInsets.left) {
                locationX += snapSize.width;
            }

            while (locationY < edgeInsets.top) {
                locationY += snapSize.height;
            }

            Dimension d = getBoundingSize(destination);

            while (locationX + destination.getSize().width + edgeInsets.right > d.width) {
                locationX -= snapSize.width;
            }

            while (locationY + destination.getSize().height + edgeInsets.bottom > d.height) {
                locationY -= snapSize.height;
            }

            destination.setLocation(locationX, locationY);
        }

        private int getDragDistance(int larger, int smaller, int snapSize) {
            int halfway = snapSize / 2;
            int drag = larger - smaller;
            drag += (drag < 0) ? -halfway : halfway;
            drag = (drag / snapSize) * snapSize;

            return drag;
        }

        private Dimension getBoundingSize(Component source) {
            if (source instanceof Window) {
                GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
                Rectangle bounds = env.getMaximumWindowBounds();
                return new Dimension(bounds.width, bounds.height);
            } else {
                return source.getParent().getSize();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (!potentialDrag) {
                return;
            }

            source.removeMouseMotionListener(this);
            potentialDrag = false;

            if (changeCursor) {
                source.setCursor(originalCursor);
            }

            if (destination instanceof JComponent) {
                ((JComponent) destination).setAutoscrolls(autoscrolls);
            }

            if (autoLayout) {
                if (destination instanceof JComponent) {
                    ((JComponent) destination).revalidate();
                } else {
                    destination.validate();
                }
            }
        }
    }
}
