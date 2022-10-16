package assignment3;

public class CannotBeBlankException extends Exception {

    public CannotBeBlankException() { super("Input field cannot be blank."); }

    public CannotBeBlankException(String field) {
        super(field + " cannot be blank.");
    }
}