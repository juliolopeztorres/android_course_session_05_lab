package oob.loggy.Home.Data.Repository;

import android.content.SharedPreferences;

import oob.loggy.Home.Domain.ClearUseCase.Repository.ClearDataInterface;

public class SharedPreferencesRepository implements ClearDataInterface {
    private SharedPreferences pref;

    public SharedPreferencesRepository(SharedPreferences pref) {
        this.pref = pref;
    }

    @Override
    public void removeKey(String key) {
        this.pref.edit().remove(key).apply();
    }
}
