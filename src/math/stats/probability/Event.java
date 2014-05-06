package math.stats.probability;

import math.exceptions.MException;

public class Event {

    private String name;
    private double probability;
    private String desc = "";
    
    public Event(String name, double probability) throws MException {
        if (probability > 1 || probability < 0) {
            throw MException.PROPORTION_OUT_BOUNDS;
        }
        this.name = name;
        this.probability = probability;
    }
    
    public Event(String name, double probability, String desc) throws MException {
        this(name, probability);
        this.desc = desc;
    }
    
    public boolean test() {
        return (Math.random() >= probability);
    }
    
    public String getName() {
        return name;
    }
    
    public String getEventDesc() {
        return (!desc.equals("") ? desc : null);
    }
    
    public double getProbability() {
        return probability;
    }
    
    public void setProbability(double prob) throws MException {
        if (prob > 1 || prob < 0) {
            throw MException.PROPORTION_OUT_BOUNDS;
        }
        probability = prob;
    }
    
    public String getConvergedName(Event second) {
        return getName() + "*" + second.getName();
    }
}
