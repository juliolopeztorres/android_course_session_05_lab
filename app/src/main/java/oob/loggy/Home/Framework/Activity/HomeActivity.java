package oob.loggy.Home.Framework.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import oob.loggy.Home.Data.Repository.ClearLoginRepository;
import oob.loggy.Home.Data.Repository.SharedPreferencesRepository;
import oob.loggy.Home.Domain.ClearUseCase.ClearLoginService;
import oob.loggy.Login.Framework.Activity.LoginActivity;
import oob.loggy.R;

public class HomeActivity extends AppCompatActivity {
    private ClearLoginService loginService;

    private TextView textViewUsername;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_logout:
                this.goToLogin();
                return true;
            case R.id.menu_forget_logout:
                this.loginService.clear();
                this.goToLogin();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.injectDependencies();
        this.bindUi();

        this.textViewUsername.setText(getIntent().getStringExtra(getString(R.string.USERNAME_KEY)));
    }

    private void injectDependencies() {
        this.loginService = new ClearLoginService(new ClearLoginRepository(new SharedPreferencesRepository(getSharedPreferences(getString(R.string.PREFERENCES_NAME), MODE_PRIVATE))));
    }

    private void bindUi() {
        this.textViewUsername = (TextView) findViewById(R.id.textViewUsername);
    }

    private void goToLogin() {
        startActivity(
            (new Intent(HomeActivity.this, LoginActivity.class))
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK)
        );
    }
}
