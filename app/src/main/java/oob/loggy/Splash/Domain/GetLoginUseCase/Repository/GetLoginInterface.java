package oob.loggy.Splash.Domain.GetLoginUseCase.Repository;

import oob.loggy.Splash.Domain.GetLoginUseCase.Exception.NoValueFoundException;

public interface GetLoginInterface {
    String getUsername() throws NoValueFoundException;
}
