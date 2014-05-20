package test;

public class Test {

    public static void main(String[] args) {
        System.out.println("TRIALS || MEAN");
        double mean = 0.0;
        double total = 0.0;
        long attempts = 0L;
        boolean first = true;
        while (true) {
            attempts++;
            total += Math.random();
            mean = total / attempts;
            if (first) {
                first = false;
            } else {
                if (mean == .5) {
                    System.err.println(attempts + " || " + mean);
                    break;
                } else {
                    System.out.println(attempts + " || " + mean);
                }
            }
        }
    }
}
