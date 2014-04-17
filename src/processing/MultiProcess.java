package processing;

public class MultiProcess implements Runnable {

    private final ProcessAction[] actions;

    public MultiProcess(ProcessAction pa1, ProcessAction pa2) {
        actions = new ProcessAction[2];
        actions[0] = pa1;
        actions[1] = pa2;
    }

    @Override
    public void run() {
        if (actions.length == 2) {
            
        }
    }
}
