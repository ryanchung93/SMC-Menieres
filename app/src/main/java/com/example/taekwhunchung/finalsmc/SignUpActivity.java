package com.example.taekwhunchung.finalsmc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void signupOnClick(View view) {
        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText unameEditText = findViewById(R.id.unameEditText);
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        EditText password2EditText = findViewById(R.id.password2EditText);

        String name = nameEditText.getText().toString();
        String uname = unameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String pass = passwordEditText.getText().toString();
        String pass2 = password2EditText.getText().toString();

        if (!pass.equals(pass2)) {
            Toast.makeText(this, "passwords don't match", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "THEY MATCH", Toast.LENGTH_SHORT).show();

            Contact c = new Contact();
            c.setName(name);
            c.setUname(uname);
            c.setEmail(email);
            c.setPass(pass);

//            helper.insertContact();
        }
    }
}
