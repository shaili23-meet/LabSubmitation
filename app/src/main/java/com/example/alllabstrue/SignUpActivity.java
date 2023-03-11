package com.example.alllabstrue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView signUp;
    private EditText name;
    private EditText email;
    private EditText password;
    private Button submit;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUp= findViewById(R.id.signup);
        mAuth= FirebaseAuth.getInstance();
        database= FirebaseDatabase.getInstance();
        name= findViewById(R.id.name);
        email= findViewById(R.id.email);
        password= findViewById(R.id.password);
        submit= findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==submit){
            create_user(email.getText().toString(), password.getText().toString());
        }
    }

    public void create_user(String email1,String password1 ){
        mAuth.createUserWithEmailAndPassword(email1, password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //if the task was successful
                            User user1= new User(name.getText().toString(), email.getText().toString(),password.getText().toString());
                            String uid= mAuth.getCurrentUser().getUid().toString();
                            database.getReference("Users").child(uid).setValue(user1);
                            Intent i= new Intent(SignUpActivity.this, HomeActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}