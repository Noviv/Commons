package processing;

public class SimpleProcess implements Runnable {

    public boolean started = false;
    private final ProcessAction pa;

    public SimpleProcess(ProcessAction pa) {
        this.pa = pa;
    }

    @Override
    public void run() {
        pa.execute();
    }
}
