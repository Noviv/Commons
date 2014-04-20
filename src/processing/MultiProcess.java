package processing;

public class MultiProcess implements Runnable {

    private final ProcessAction[] actions;

    /**
     * Whether or not this <code>MultiProcess</code> has dual process or
     * multiple processes.
     */
    public final boolean dualprocess;

    /**
     * Create a new <code>MultiProcess</code> with a dual process.
     *
     * @param pa1 First action.
     * @param pa2 Second action.
     */
    public MultiProcess(ProcessAction pa1, ProcessAction pa2) {
        dualprocess = true;
        actions = new ProcessAction[2];
        actions[0] = pa1;
        actions[1] = pa2;
    }

    /**
     * Create a <code>MultiProcess</code> with multiple actions.
     *
     * @param pas Array of actions.
     */
    public MultiProcess(ProcessAction[] pas) {
        dualprocess = false;
        if (pas.length > 2) {
            actions = pas;
        } else {
            actions = null;
        }
    }

    @Override
    public void run() {
        if (actions != null) {
            for (ProcessAction a : actions) {
                if (a != null) {
                    a.execute();
                }
            }
        }
    }
}
