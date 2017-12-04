package oob.loggy.Splash.Data;

import android.content.SharedPreferences;

import oob.loggy.Splash.Domain.GetLoginUseCase.Exception.NoValueFoundException;
import oob.loggy.Splash.Domain.GetLoginUseCase.Repository.GetDataInterface;

public class SharedPreferencesRepository implements GetDataInterface {
    private SharedPreferences pref;

    public SharedPreferencesRepository(SharedPreferences pref) {
        this.pref = pref;
    }

    @Override
    public String getString(String key) throws NoValueFoundException {
        String value = this.pref.getString(key, null);
        if (value == null) {
            throw new NoValueFoundException(key);
        }

        return value;
    }
}
