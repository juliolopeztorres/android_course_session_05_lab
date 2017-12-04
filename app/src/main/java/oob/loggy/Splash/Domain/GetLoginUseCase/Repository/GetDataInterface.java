package oob.loggy.Splash.Domain.GetLoginUseCase.Repository;

import oob.loggy.Splash.Domain.GetLoginUseCase.Exception.NoValueFoundException;

public interface GetDataInterface {
    String getString(String key) throws NoValueFoundException;
}
