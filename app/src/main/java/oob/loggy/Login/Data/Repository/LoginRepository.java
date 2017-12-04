package oob.loggy.Login.Data.Repository;

import oob.loggy.Login.Domain.LoginUseCase.Exception.NoValueFoundException;
import oob.loggy.Login.Domain.LoginUseCase.LoginRequest;
import oob.loggy.Login.Domain.LoginUseCase.Repository.DataInterface;
import oob.loggy.Login.Domain.LoginUseCase.Repository.LoginInterface;

public class LoginRepository implements LoginInterface {
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";
    private static final String REMEMBER_ME_KEY = "remember_me";

    private DataInterface dataRepository;

    public LoginRepository(DataInterface dataRepository) {
        this.dataRepository = dataRepository;
    }

    public Boolean login(LoginRequest loginRequest) {
        this.dataRepository.setString(USERNAME_KEY, loginRequest.getUsername());
        this.dataRepository.setString(PASSWORD_KEY, loginRequest.getPassword());
        this.dataRepository.setBoolean(REMEMBER_ME_KEY, loginRequest.getRememberMe());

        return true;
    }

    @Override
    public String getUsername() throws NoValueFoundException {
        return this.dataRepository.getString(USERNAME_KEY);
    }

    @Override
    public String getPassword() throws NoValueFoundException {
        return this.dataRepository.getString(PASSWORD_KEY);
    }

    @Override
    public boolean getRememberMe() {
        return this.dataRepository.getBoolean(REMEMBER_ME_KEY);
    }
}
