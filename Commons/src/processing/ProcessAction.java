package processing;

import data.datastructures.InfoSet;

/**
 * A user-defined action that is executed in Commons processing.
 *
 * @author Matthew
 */
public abstract class ProcessAction implements Runnable {

    public InfoSet info = null;

    /**
     * Add a relative <code>InfoSet</code> to the action, in case you want
     * information about it.
     *
     * @param i
     */
    public void putInfoSet(InfoSet i) {
        info = i;
    }
}
