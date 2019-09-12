package junit.cases.exceptions;

@SuppressWarnings("serial")
public class CustomBusinessException extends Exception {

    public CustomBusinessException() {
        super("custom business exception");
    }
}
