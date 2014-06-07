package modeling;

import cInterfaces.Equatable;
import evolutionary.Environment;

public abstract class Model implements Equatable {

    private final String UID;

    public Model(String UID, boolean activeOnInit) {
        this.UID = UID;
    }

    /**
     * Gets whether or not the model is active (dynamic).
     *
     * @return True means that the model is active.
     */
    public abstract boolean isActive();

    /**
     * Gets whether or not this model is ready to be applied to relative
     * environments.
     *
     * @return True means it can be used for modeling.
     */
    public abstract boolean isModelable();

    /**
     * The Commons UID of the model.
     *
     * @return String containing the UID (unmodified).
     */
    public abstract String getUID();

    /**
     * Use the model to predict some graphical data. Use ONLY with graphical
     * models.
     *
     * @param interpret An list of values depending on whether the model is
     * multivariable.
     * @return The double value from the model.
     */
    public abstract double predict(double... interpret);

    /**
     * Apply this model to a given <code>Environment</code>, which assigns the
     * evolutionary object an AI grouping.
     *
     * @param e
     */
    public abstract void apply(Environment e);
}
