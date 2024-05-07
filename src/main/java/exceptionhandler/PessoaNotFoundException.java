package exceptionhandler;

public class PessoaNotFoundException extends RuntimeException {

    public PessoaNotFoundException(String message) {
        super(message);
    }
}
