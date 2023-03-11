package com.example.alllabstrue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView signInT;
    private EditText password;
    private EditText email;
    private Button signInB;
    private Button signUpB;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth= FirebaseAuth.getInstance();
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
            signin_user(email.getText().toString(), password.getText().toString());
        }
        if(view==signUpB){
            Intent i= new Intent(this, SignUpActivity.class);
            startActivity(i);
        }
    }

    public void signin_user(String email,String password ){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent i= new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}