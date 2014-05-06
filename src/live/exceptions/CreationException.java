package live.exceptions;

public class CreationException extends Exception {
    
    public static final CreationException DOES_NOT_EXIST_EXCEP = new CreationException("Could not create because a parameter or the object does not exist.");

    public CreationException(String msg) {
        super(msg);
    }
}
