package processing;

public class SimpleProcess implements Runnable {

    /**
     * Whether or not this process has started.
     */
    public boolean started = false;
    private final ProcessAction pa;
    private boolean daemon;

    /**
     * Creates a new <code>SimpleProcess</code>.
     *
     * @param pa The <code>ProcessAction</code> that this process will execute.
     */
    public SimpleProcess(ProcessAction pa) {
        daemon = false;
        this.pa = pa;
    }

    /**
     * Set the process to a daemon process.
     *
     * @param daemon True means that this process will be a daemon thread.
     */
    public void setDaemon(boolean daemon) {
        daemon = true;
    }

    @Override
    public void run() {
        if (daemon) {
        } else {
            started = true;
            pa.execute();
        }
    }
}
