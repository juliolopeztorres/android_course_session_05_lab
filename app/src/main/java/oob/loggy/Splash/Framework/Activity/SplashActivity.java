package oob.loggy.Splash.Framework.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import oob.loggy.Home.Framework.Activity.HomeActivity;
import oob.loggy.Login.Framework.Activity.LoginActivity;
import oob.loggy.R;
import oob.loggy.Splash.Data.GetLoginRepository;
import oob.loggy.Splash.Data.SharedPreferencesRepository;
import oob.loggy.Splash.Domain.GetLoginUseCase.Exception.NoValueFoundException;
import oob.loggy.Splash.Domain.GetLoginUseCase.GetLoginService;

public class SplashActivity extends AppCompatActivity {

    private GetLoginService loginService;
    private Class callbackSuccessActivity;
    private Class callbackErrorActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.injectDependencies();
        startActivity(this.getSpecificIntent());
        finish();
    }

    private void injectDependencies() {
        this.loginService = new GetLoginService(new GetLoginRepository(new SharedPreferencesRepository(getSharedPreferences(getString(R.string.PREFERENCES_NAME), MODE_PRIVATE))));
        this.callbackSuccessActivity = HomeActivity.class;
        this.callbackErrorActivity = LoginActivity.class;
    }

    private Intent getSpecificIntent() {
        Intent intent = new Intent();
        try {
            String username = this.loginService.getUsername();
            intent.putExtra(getString(R.string.USERNAME_KEY), username);
            intent.setClass(SplashActivity.this, callbackSuccessActivity);
        } catch (NoValueFoundException exc) {
            intent.setClass(SplashActivity.this, callbackErrorActivity);
        }

        return intent;
    }
}
