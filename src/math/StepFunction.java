package math;

import java.util.Stack;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import math.exceptions.MException;

public class StepFunction extends Function2D {

    private final Stack<FunctionStep> steps;

    public StepFunction() {
        steps = new Stack<>();
    }

    public void add(FunctionStep fs) {
        steps.add(fs);
    }

    @Override
    public double func(double x) {
        double xAli = x;
        for (FunctionStep fs : steps) {
            xAli = fs.func(xAli, x);
        }
        return xAli;
    }

    public static class FunctionStep {

        private final ScriptEngine engine;

        private String function;

        public FunctionStep(String step) throws MException {
            engine = new ScriptEngineManager().getEngineByName("JavaScript");

            if (step.contains("x0")) {
                function = step;
            } else {
                throw new MException("Cannot make step because it does not have x0.");
            }
        }

        public double func(double x0, double X) {
            String alias = function.trim().replace(" ", "");
            alias = alias.replace("x0", x0 + "");
            if (alias.contains("X")) {
                alias = alias.replace("X", X + "");
            }
            
            try {
                Double obj = (Double) engine.eval(alias);
                return obj;
            } catch (ScriptException | ClassCastException e) {
                System.err.println("err with: " + alias);
            }
            return 0.0;
        }
    }
}
