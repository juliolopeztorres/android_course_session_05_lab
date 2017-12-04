package oob.loggy.Login.Domain.LoginUseCase.Exception;

public class NoValueFoundException extends Exception {
    private static final String MESSAGE_FORMAT = "No valid key (%s) found in storage data";

    private int code = 3;
    private String message = "";

    public NoValueFoundException(String key) {
        this.message = String.format(MESSAGE_FORMAT, key);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
