package oob.loggy.Login.Domain.LoginUseCase;

public class LoginRequest {
    private String username;

    private String password;

    private boolean rememberMe;

    public boolean getRememberMe() {
        return rememberMe;
    }

    public LoginRequest setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoginRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
