package assignment3;

public class NoEmployeesException extends RuntimeException {
    public NoEmployeesException() {
        super("No employees registered yet.");
    }
}
