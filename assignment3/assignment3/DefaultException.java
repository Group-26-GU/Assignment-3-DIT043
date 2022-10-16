package assignment3;

public class DefaultException extends Exception {
    public DefaultException(){
        super("There occurred an error in the execution.");
    }
    public DefaultException(String message) {
        super(message);
    }
}