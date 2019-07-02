package com.example.pizzaloop1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Login extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private Button Login;
    private Button Register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = (EditText) findViewById(R.id.getEmail);
        Password = (EditText) findViewById(R.id.getPassword);
        Login = (Button) findViewById(R.id.btnLogin);
        Register = (Button) findViewById(R.id.btn_registration);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegPage();
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });

    }
    public void openRegPage(){
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
    }

    private void validate(String userEmail, String userpassword) {
        if ((userEmail.equals("ashan")) && (userpassword.equals("12") )) {
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }

    }
}
