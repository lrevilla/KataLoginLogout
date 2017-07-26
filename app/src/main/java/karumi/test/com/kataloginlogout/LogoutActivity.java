package karumi.test.com.kataloginlogout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button logoutButton = (Button) findViewById(R.id.logout_button);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clock clock = new Clock();
                APIClient apiClient = new APIClient(clock);
                boolean logoutResponse = apiClient.logout();

                if (logoutResponse) {
                    Intent loginIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(loginIntent);
                } else {
                    View parentLayout = findViewById(android.R.id.content);
                    Snackbar.make(parentLayout,
                            "Nope.",
                            Snackbar.LENGTH_SHORT).show();
                }
            }
        });

    }

}
