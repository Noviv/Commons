package evolutionary;

import java.util.ArrayList;
import java.util.List;
import modeling.Model;

public class Environment implements Runnable {

    private final ArrayList<EvolutionaryObject> objects;
    private ArrayList<EvolutionaryParameter> params;

    private Model evolModel;

    private boolean inEvolution;
    private int evolutionIteration;

    public Environment() {
        inEvolution = false;
        evolutionIteration = 0;
        objects = new ArrayList<>();
        params = new ArrayList<>();
    }

    public void loadParams(List<EvolutionaryParameter> params) {
        this.params = (ArrayList) params;
    }

    public boolean addModel(Model m) {
        if (m.isActive() && m.isModelable()) {
            evolModel = m;
            return true;
        } else {
            return false;
        }
    }

    public int currentGeneration() {
        return evolutionIteration;
    }

    public synchronized boolean isEvolving() {
        return inEvolution;
    }

    @Override
    public void run() {
        inEvolution = true;
        //this is where shit gets hard
    }
}
