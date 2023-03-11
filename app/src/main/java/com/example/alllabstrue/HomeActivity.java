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

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private TextView msg;
    private ListView listView;
    private ArrayList<User> users;
    private ArrayAdapter<User> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        msg= findViewById(R.id.textView);
        listView= findViewById(R.id.homelistview);
        users= new ArrayList<>();
        users.add(new User("shai","shay", 12345));
        users.add(new User("yaniv", "shaylindf", 345678));
        arrayAdapter= new UserArrayAdapter(this, R.layout.user_row, users);
        listView.setAdapter(arrayAdapter);
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
            Intent i= new Intent(this, MainActivity.class);
            startActivity(i);
        }
        return true;
    }
}