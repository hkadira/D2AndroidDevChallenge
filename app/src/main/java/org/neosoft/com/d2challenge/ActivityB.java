package org.neosoft.com.d2challenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String mail = extras.getString("mail");
            String password = extras.getString("password");

            TextView txtEm =(TextView)findViewById(R.id.txtEmail);
            txtEm.setText(mail);
            TextView txtPwd =(TextView)findViewById(R.id.txtPwd);
            txtPwd.setText(password);
        }
    }
}
