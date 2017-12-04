package oob.loggy.Login.Domain.LoginUseCase.Exception;

public class NoValidPasswordException extends Exception {
    private static final String MESSAGE_FORMAT = "No valid password entered. Its length must be, at least, 4. Your input was: %s";

    private int code = 2;
    private String message = "";

    public NoValidPasswordException(String password) {
        this.message = String.format(MESSAGE_FORMAT, password);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
