package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hospital.database.DBAdapter;

public class MainActivity extends AppCompatActivity {
    private final AppCompatActivity activity = MainActivity.this;


    DBAdapter adapter;
    private EditText username, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //--------------toolbar--------------------
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        TextView toolbarText = findViewById(R.id.toolbar_title);

        toolbar.setTitle("");
        toolbarText.setText("Log in");

        //---------------------database---------

        adapter = new DBAdapter(this);
        //-------------init------------------
        username = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        TextView register = findViewById(R.id.register);
        //---------------------------------
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddPatient.class));
            }
        });
    }

    public void logIn(View view) {
        viewData(view);
    }

    public void viewData(View view) {
        String[] data = adapter.getData( username.getText().toString());
        String password = data[6];
        if (pass.getText().toString().equals(password)){
        Intent intent = new Intent(this, ViewPatient.class);
        intent.putExtra("Data", data);
        startActivity(intent);
        }else{
            Toast.makeText(activity, "Wrong password, try again", Toast.LENGTH_SHORT).show();
        }
    }

}
