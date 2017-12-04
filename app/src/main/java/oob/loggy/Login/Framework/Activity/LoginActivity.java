package oob.loggy.Login.Framework.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import oob.loggy.Home.Framework.Activity.HomeActivity;
import oob.loggy.Login.Data.Repository.LoginRepository;
import oob.loggy.Login.Data.Repository.SharedPreferencesRepository;
import oob.loggy.Login.Domain.LoginUseCase.Exception.NoValidPasswordException;
import oob.loggy.Login.Domain.LoginUseCase.Exception.NoValidUsernameException;
import oob.loggy.Login.Domain.LoginUseCase.Exception.NoValueFoundException;
import oob.loggy.Login.Domain.LoginUseCase.LoginRequest;
import oob.loggy.Login.Domain.LoginUseCase.LoginService;
import oob.loggy.R;

public class LoginActivity extends AppCompatActivity {
    private LoginService loginService;

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button btnLogin;
    private Switch switchRememberMe;

    private Class callbackActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.injectDependencies();
        this.bindUI();
        this.loadLoginData();
        this.setEvents();
    }

    private void injectDependencies() {
        this.loginService = new LoginService(new LoginRepository(new SharedPreferencesRepository(getSharedPreferences(getString(R.string.PREFERENCES_NAME), MODE_PRIVATE))));
        this.callbackActivity = HomeActivity.class;
    }

    private void bindUI() {
        this.editTextUsername = (EditText) findViewById(R.id.editTextEmail);
        this.editTextPassword = (EditText) findViewById(R.id.editTextPass);
        this.btnLogin = (Button) findViewById(R.id.buttonLogin);
        this.switchRememberMe = (Switch) findViewById(R.id.switchRememberMe);
    }

    private void loadLoginData() {
        try {
            this.editTextUsername.setText(this.loginService.getUsername());
            this.editTextPassword.setText(this.loginService.getPassword());
            this.switchRememberMe.setChecked(this.loginService.getRememberMe());
        } catch (NoValueFoundException exc) {
        }
    }

    private void setEvents() {
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login(switchRememberMe.isChecked())) {
                    startActivity(
                            (new Intent(LoginActivity.this, callbackActivity))
                                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                    .putExtra(getString(R.string.USERNAME_KEY), editTextUsername.getText().toString())
                    );
                }
            }
        });
    }

    private Boolean login(boolean rememberMe) {
        try {
            return this.loginService.login(
                    (new LoginRequest())
                            .setUsername(this.editTextUsername.getText().toString())
                            .setPassword(this.editTextPassword.getText().toString())
                            .setRememberMe(rememberMe)
            );
        } catch (NoValidUsernameException | NoValidPasswordException exc) {
            Toast.makeText(this, exc.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return false;
    }
}
