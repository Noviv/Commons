package math.stats.probability;

import math.exceptions.MException;

public class Event {

    private String name;
    private double probability;
    private String desc = "";

    /**
     * Create a new statistical event.
     *
     * @param name The name of the event.
     * @param probability The probability that the event will occur.
     * @throws MException Thrown if the probability is above 1 or below 0.
     */
    public Event(String name, double probability) throws MException {
        if (probability > 1 || probability < 0) {
            throw MException.PROPORTION_OUT_BOUNDS;
        }
        this.name = name;
        this.probability = probability;
    }

    /**
     * Create a new statistical event.
     *
     * @param name The name of the event.
     * @param probability The probability that the event will occur.
     * @param desc The description of the event.
     * @throws MException Thrown if the probability is above 1 or below 0.
     */
    public Event(String name, double probability, String desc) throws MException {
        this(name, probability);
        this.desc = desc;
    }

    /**
     * Test the event using <code>Math.random()</code>.
     *
     * @return True if <code>Math.random()</code> is >= probability.
     */
    public boolean test() {
        return (Math.random() >= probability);
    }

    /**
     * Get the name of the event.
     *
     * @return Name as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the description of the event.
     *
     * @return The description, or "" if no description was provided.
     */
    public String getEventDesc() {
        return (desc.equals("") || desc.equals(" ") ? "" : desc);
    }

    /**
     * Gets the probability of this event happening.
     *
     * @return Probability as a double, between 1 and 0.
     */
    public double getProbability() {
        return probability;
    }

    /**
     * Change the probability that this event will occur.
     *
     * @param prob The new probability as a double.
     * @throws MException Thrown if the new probability is not between 1 and 0.
     */
    public void setProbability(double prob) throws MException {
        if (prob > 1 || prob < 0) {
            throw MException.PROPORTION_OUT_BOUNDS;
        }
        probability = prob;
    }

    /**
     * Checks whether or not this event is independent against a given event.
     *
     * @param e The new <code>Event</code> to check against.
     * @return True if the two events are mathematically independent.
     */
    public boolean checkIndependenceAgainst(Event e) {
        return (probability * e.getProbability()) / e.getProbability() == e.getProbability() || (e.getProbability() * probability) / probability == probability;
    }
}
