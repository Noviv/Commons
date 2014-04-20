package processing;

public class SimpleProcess implements Runnable {

    /**
     * Whether or not this process has started.
     */
    public boolean started = false;
    private final ProcessAction pa;

    /**
     * Creates a new <code>SimpleProcess</code>.
     * @param pa The <code>ProcessAction</code> that this process will execute.
     */
    public SimpleProcess(ProcessAction pa) {
        this.pa = pa;
    }

    @Override
    public void run() {
        started = true;
        pa.execute();
    }
}
