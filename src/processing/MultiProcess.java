package processing;

public class MultiProcess implements Runnable {

    private final ProcessAction[] actions;

    public MultiProcess(ProcessAction pa1, ProcessAction pa2) {
        actions = new ProcessAction[2];
        actions[0] = pa1;
        actions[1] = pa2;
    }

    public MultiProcess(ProcessAction[] pas) {
        if (pas.length > 2) {
            actions = pas;
        } else {
            actions = null;
        }
    }

    @Override
    public void run() {
        if (actions != null) {
            if (actions.length >= 2) {
                
            } else {
                actions[0].execute();
            }
        }
    }
}
