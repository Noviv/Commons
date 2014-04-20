package processing;

import info.InfoSet;

public abstract class ProcessAction {

    public InfoSet info = null;

    public abstract void execute();
    
    public void putInfoSet(InfoSet i) {
        info = i;
    }
}
