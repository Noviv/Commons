package modeling;

import cInterfaces.Equatable;

public abstract class Model implements Equatable {
    private final String UID;
    
    
    public Model(String UID, boolean activeOnInit) {
        this.UID = UID;
    }

    protected abstract boolean isActive();

    protected abstract boolean isModelable();

    protected abstract String getUID();
    
    public abstract double predict();
    
    public abstract double apply();
}
