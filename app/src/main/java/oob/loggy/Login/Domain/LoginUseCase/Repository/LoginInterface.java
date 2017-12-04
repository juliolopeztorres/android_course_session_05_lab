package oob.loggy.Login.Domain.LoginUseCase.Repository;

import oob.loggy.Login.Domain.LoginUseCase.Exception.NoValueFoundException;
import oob.loggy.Login.Domain.LoginUseCase.LoginRequest;

public interface LoginInterface {
    Boolean login(LoginRequest loginRequest);

    String getUsername() throws NoValueFoundException;

    String getPassword() throws NoValueFoundException;

    boolean getRememberMe();
}
