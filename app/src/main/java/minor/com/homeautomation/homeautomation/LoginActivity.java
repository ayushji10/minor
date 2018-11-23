package minor.com.homeautomation.homeautomation;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText etname;
    EditText etpass;
    Button btlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");

        etname = findViewById(R.id.et_signup_email);
        etpass = findViewById(R.id.et_signup_password);

        btlogin = findViewById(R.id.bt_login);

        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyInputs();
            }
        });

    }

    private void verifyInputs() {
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Logging you in...");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        String name = etname.getText().toString();
        String pass = etpass.getText().toString();

        if (name.isEmpty()){
            etname.setError("Name is required!");
            etname.requestFocus();
            progressDialog.dismiss();
            return;
        }

        if (pass.isEmpty()){
            etpass.setError("Password is required!");
            etpass.requestFocus();
            progressDialog.dismiss();
            return;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        },2000);
    }
}
