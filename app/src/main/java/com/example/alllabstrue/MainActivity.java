package com.example.alllabstrue;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView signInT;
    private EditText password;
    private EditText email;
    private Button signInB;
    private Button signUpB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signInT= findViewById(R.id.signinT);
        password= findViewById(R.id.password);
        email= findViewById(R.id.email);
        signInB= findViewById(R.id.signinB);
        signUpB=findViewById(R.id.signupB);
        signInB.setOnClickListener(this);
        signUpB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==signInB){
            Intent i= new Intent(this, HomeActivity.class);
            startActivity(i);
        }
        if(view==signUpB){
            Intent i= new Intent(this, SignUpActivity.class);
            startActivity(i);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}