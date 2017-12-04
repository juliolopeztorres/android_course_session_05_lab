package oob.loggy.Splash.Domain.GetLoginUseCase;

import oob.loggy.Splash.Domain.GetLoginUseCase.Exception.NoValueFoundException;
import oob.loggy.Splash.Domain.GetLoginUseCase.Repository.GetLoginInterface;

public class GetLoginService {
    private GetLoginInterface loginInterface;

    public GetLoginService(GetLoginInterface loginInterface) {
        this.loginInterface = loginInterface;
    }

    public String getUsername() throws NoValueFoundException {
        return this.loginInterface.getUsername();
    }
}
