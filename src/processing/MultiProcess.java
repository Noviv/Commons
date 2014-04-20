package processing;

public class MultiProcess implements Runnable {

    public static void main(String[] args) {
        ProcessAction pa1 = new ProcessAction() {
            @Override
            public void execute() {
                System.out.println("pa1");
            }
        };
        ProcessAction pa2 = new ProcessAction() {
            @Override
            public void execute() {
                System.out.println("pa2");
            }
        };
        new MultiProcess(pa1, pa2).run();
    }

    private final ProcessAction[] actions;
    public final boolean dualprocess;

    public MultiProcess(ProcessAction pa1, ProcessAction pa2) {
        dualprocess = true;
        actions = new ProcessAction[2];
        actions[0] = pa1;
        actions[1] = pa2;
    }

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
