package oob.loggy.Login.Data.Repository;

import android.content.SharedPreferences;

import oob.loggy.Login.Domain.LoginUseCase.Exception.NoValueFoundException;
import oob.loggy.Login.Domain.LoginUseCase.Repository.DataInterface;

public class SharedPreferencesRepository implements DataInterface {
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

    @Override
    public void setString(String key, String value) {
        this.pref.edit().putString(key, value).apply();
    }

    @Override
    public void setBoolean(String key, boolean value) {
        this.pref.edit().putBoolean(key, value).apply();
    }

    @Override
    public boolean getBoolean(String key) {
        return this.pref.getBoolean(key, false);
    }
}
