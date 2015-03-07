package graphics.math;

import java.awt.image.BufferedImage;

/**
 * Method getMandelbrot(...) based on modified Rosetta Code algorithm.
 */
public class MandelbrotSet {

    private static double zx, zy, cX, cY, tmp;
    private static BufferedImage I;

    private MandelbrotSet() {
    }

    /**
     * Get an image of the mandelbrot set.
     *
     * @param height The height of the image.
     * @param width The width of the image.
     * @param max_iter The max number of iterations that the set should account for.
     * @param zoom The zoom factor (bigger means closer).
     * @return An image of the mandelbrot set.
     */
    public static BufferedImage getMandelbrot(int height, int width, int max_iter, double zoom) {
        I = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                zx = zy = 0;
                cX = (x - 400) / zoom;
                cY = (y - 300) / zoom;
                int iter = max_iter;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter--;
                }
                I.setRGB(x, y, iter | (iter << 8));
            }
        }
        return I;
    }
}
