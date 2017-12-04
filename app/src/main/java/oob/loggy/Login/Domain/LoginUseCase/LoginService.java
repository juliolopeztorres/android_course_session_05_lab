package oob.loggy.Login.Domain.LoginUseCase;

import android.text.TextUtils;

import oob.loggy.Login.Domain.LoginUseCase.Exception.NoValidPasswordException;
import oob.loggy.Login.Domain.LoginUseCase.Exception.NoValidUsernameException;
import oob.loggy.Login.Domain.LoginUseCase.Exception.NoValueFoundException;
import oob.loggy.Login.Domain.LoginUseCase.Repository.LoginInterface;

public class LoginService {
    private static final int PASSWORD_MINIMUM_LENGTH = 4;
    private LoginInterface loginInterface;

    public LoginService(LoginInterface loginInterface) {
        this.loginInterface = loginInterface;
    }

    public boolean login(LoginRequest loginRequest) throws NoValidUsernameException, NoValidPasswordException {
        this.checkValidLoginRequest(loginRequest);

        if (loginRequest.getRememberMe()) {
            return this.loginInterface.login(loginRequest);
        }
        return true;
    }

    private void checkValidLoginRequest(LoginRequest loginRequest) throws NoValidUsernameException, NoValidPasswordException {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (!this.checkValidUsername(username)) {
            throw new NoValidUsernameException(username);
        }

        if (!this.checkValidPassword(password)) {
            throw new NoValidPasswordException(password);
        }
    }

    private boolean checkValidUsername(String username) {
        return !TextUtils.isEmpty(username);
    }

    private boolean checkValidPassword(String password) {
        return !this.checkEmpty(password) && this.checkSecureRequirements(password);
    }

    private boolean checkEmpty(String string) {
        return TextUtils.isEmpty(string);
    }

    private boolean checkSecureRequirements(String password) {
        return password.length() >= PASSWORD_MINIMUM_LENGTH;
    }

    public String getUsername() throws NoValueFoundException {
        return this.loginInterface.getUsername();
    }

    public String getPassword() throws NoValueFoundException {
        return this.loginInterface.getPassword();
    }

    public boolean getRememberMe() {
        return this.loginInterface.getRememberMe();
    }
}
