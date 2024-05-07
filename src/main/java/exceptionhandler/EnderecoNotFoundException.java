package exceptionhandler;

public class EnderecoNotFoundException extends RuntimeException {

    public EnderecoNotFoundException(String message) {
        super(message);
    }
}
