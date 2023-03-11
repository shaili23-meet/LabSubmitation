package com.example.alllabstrue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private TextView msg;
    private ListView listView;
    private ArrayList<User> users;
    private ArrayAdapter<User> arrayAdapter;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAuth= FirebaseAuth.getInstance();
        database= FirebaseDatabase.getInstance();
        database.getReference("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                users= new ArrayList<>();
                for (DataSnapshot data:snapshot.getChildren()){
                    users.add(data.getValue(User.class));
                }
                msg= findViewById(R.id.textView);
                listView= findViewById(R.id.homelistview);

                arrayAdapter= new UserArrayAdapter(HomeActivity.this, R.layout.user_row, users);
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.signOut){
            mAuth.signOut();
            Intent i= new Intent(this, MainActivity.class);
            startActivity(i);
        }
        return true;
    }
}