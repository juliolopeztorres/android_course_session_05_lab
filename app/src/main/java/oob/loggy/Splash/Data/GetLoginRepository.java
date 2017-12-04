package oob.loggy.Splash.Data;

import oob.loggy.Splash.Domain.GetLoginUseCase.Exception.NoValueFoundException;
import oob.loggy.Splash.Domain.GetLoginUseCase.Repository.GetDataInterface;
import oob.loggy.Splash.Domain.GetLoginUseCase.Repository.GetLoginInterface;

public class GetLoginRepository implements GetLoginInterface {
    private static final String USERNAME_KEY = "username";

    private GetDataInterface dataRepository;

    public GetLoginRepository(GetDataInterface dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public String getUsername() throws NoValueFoundException {
        return this.dataRepository.getString(USERNAME_KEY);
    }
}
