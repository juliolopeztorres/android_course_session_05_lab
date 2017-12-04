package oob.loggy.Home.Data.Repository;

import oob.loggy.Home.Domain.ClearUseCase.Repository.ClearDataInterface;
import oob.loggy.Home.Domain.ClearUseCase.Repository.ClearLoginInterface;

public class ClearLoginRepository implements ClearLoginInterface {
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";
    private static final String REMEMBER_ME_KEY = "remember_me";

    private ClearDataInterface dataRepository;

    public ClearLoginRepository(ClearDataInterface dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void clear() {
        this.dataRepository.removeKey(USERNAME_KEY);
        this.dataRepository.removeKey(PASSWORD_KEY);
        this.dataRepository.removeKey(REMEMBER_ME_KEY);
    }
}
