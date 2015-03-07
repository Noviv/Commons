package live;

public class DashboardException extends Exception {

    public static DashboardException ID_ALREADY_EXISTS = new DashboardException("Tried to create a Dashboard with a preexisting ID.");

    public DashboardException(String cause) {
        super(cause);
    }
}
