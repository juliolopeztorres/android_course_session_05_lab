package oob.loggy.Home.Domain.ClearUseCase;

import oob.loggy.Home.Domain.ClearUseCase.Repository.ClearLoginInterface;

public class ClearLoginService {
    private ClearLoginInterface loginInterface;

    public ClearLoginService(ClearLoginInterface loginInterface) {
        this.loginInterface = loginInterface;
    }

    public void clear() {
        this.loginInterface.clear();
    }
}
