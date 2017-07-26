package karumi.test.com.kataloginlogout;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText userEditText = (EditText)findViewById(R.id.edit_user);
        final EditText passwordEditText = (EditText) findViewById(R.id.edit_password);
        final Button loginButton = (Button) findViewById(R.id.login_button);

        loginButton.setEnabled(false);

        userEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean shouldEnableButton = !s.toString().isEmpty();
                loginButton.setEnabled(shouldEnableButton);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = userEditText.getText().toString();
                String pass = passwordEditText.getText().toString();
                Clock clock = new Clock();
                APIClient apiClient = new APIClient(clock);
                boolean loginResponse = apiClient.login(email, pass);
                View parentLayout = findViewById(android.R.id.content);
                if (!loginResponse) {
                    Snackbar.make(parentLayout,
                                  "Oops, wrong credentials.",
                                  Snackbar.LENGTH_SHORT).show();
                } else {
                    Intent logoutIntent = new Intent(getApplicationContext(), LogoutActivity.class);
                    startActivity(logoutIntent);
                }
            }
        });
    }
}
