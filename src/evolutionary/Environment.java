package evolutionary;

import modeling.Model;

public class Environment {

    private Model evolModel;

    public boolean addModel(Model m) {
        if (m.isActive() && m.isModelable()) {
            evolModel = m;
            return true;
        } else {
            return false;
        }
    }
}
