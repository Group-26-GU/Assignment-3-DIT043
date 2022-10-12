package assignment3;

public class CannotBeBlankException extends RuntimeException {

    public CannotBeBlankException(String field) {
        super(field + " cannot be blank.");
    }
}