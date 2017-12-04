package oob.loggy.Login.Domain.LoginUseCase.Repository;

import oob.loggy.Login.Domain.LoginUseCase.Exception.NoValueFoundException;

public interface DataInterface {
    String getString(String key) throws NoValueFoundException;

    void setString(String key, String value);

    void setBoolean(String key, boolean value);

    boolean getBoolean(String key);
}
