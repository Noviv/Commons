package graphics.fractal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DynamicTreeFractal {

    private DynamicTreeFractal() {
    }

    public static synchronized void drawDTFractal(Graphics g, int startX, int startY, int maxBranches) throws Exception {
        if (g == null) {
            throw new Exception("Cannot draw on null graphics!");
        }
        g.setColor(Color.black);

        int currBranches = 0;
        int created = 0;
        Node baseNode = new Node(startX, startY);
        Node temp;
        ArrayList<Node> allNodes = new ArrayList<>();
        allNodes.add(baseNode);
        created++;

        while (currBranches < maxBranches) {
            g.clearRect(-10, -10, 3000, 3000);
            for (Node n : allNodes) {
                n.draw(g);
                temp = n.createBranch();
                if (temp != null) {
                    allNodes.add(temp);
                    created++;
                }
            }

            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
            } finally {
                currBranches += created;
                created = 0;
            }
        }
    }

    private static class Node {

        public int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public synchronized Node createBranch() {
            if (Math.random() < .2) {
                if (Math.random() > .5) {
                    return new Node(x - 25, y - 25);
                } else {
                    return new Node(x + 25, y + 25);
                }
            } else {
                return null;
            }
        }

        public synchronized void draw(Graphics g) {
            g.fillOval(x - 5, y - 5, 10, 10);
        }
    }
}
