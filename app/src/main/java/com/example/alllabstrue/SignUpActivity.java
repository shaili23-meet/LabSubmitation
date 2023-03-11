package com.example.alllabstrue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView signUp;
    private EditText name;
    private EditText email;
    private EditText password;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUp= findViewById(R.id.signup);
        name= findViewById(R.id.name);
        email= findViewById(R.id.email);
        password= findViewById(R.id.password);
        submit= findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==submit){
            Intent i= new Intent(this, HomeActivity.class);
            startActivity(i);
        }
    }
}