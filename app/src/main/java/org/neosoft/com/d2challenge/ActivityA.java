package org.neosoft.com.d2challenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import static org.neosoft.com.d2challenge.R.id.edTxtEmail;

public class ActivityA extends AppCompatActivity {
    EditText email,pwd;
    TextInputLayout tilE,tilP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        email=(EditText)findViewById(edTxtEmail);
        pwd=(EditText) findViewById(R.id.edTxtPwd);

        tilE= (TextInputLayout) findViewById(R.id.lEmail);
        tilP = (TextInputLayout) findViewById(R.id.lPwd);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEmail= email.getText().toString().trim();
                String strPwd= pwd.getText().toString().trim();

                if(TextUtils.isEmpty(strEmail)){
                    tilE.setError("Email can't be empty...");
                    tilP.setError(null);
                }else if(TextUtils.isEmpty(strPwd)){
                    tilP.setError("Password can't be empty...");
                    tilE.setError(null);
                } else if (!Patterns.EMAIL_ADDRESS.matcher(strEmail).matches()) {
                    email.setError("Invalid Email");
                    email.requestFocus();
                    tilP.setError(null);
                } else{
                        Intent i = new Intent(getBaseContext(),ActivityB.class);
                        i.putExtra("mail",strEmail);
                        i.putExtra("password",strPwd);
                        startActivity(i);
                        finish();
                }
            }
        });
    }
}
