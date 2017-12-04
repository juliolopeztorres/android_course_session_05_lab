package oob.loggy.Login.Domain.LoginUseCase.Exception;

public class NoValidUsernameException extends Exception {
    private static final String MESSAGE_FORMAT = "No valid username entered. Your input was: %s";

    private int code = 1;
    private String message = "";

    public NoValidUsernameException(String username) {
        this.message = String.format(MESSAGE_FORMAT, username);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
