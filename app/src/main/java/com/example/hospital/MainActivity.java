package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   private TextView username ,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      Toolbar  toolbar = (Toolbar)findViewById(R.id.tool);
      TextView toolbarText =findViewById(R.id.toolbar_title);

        toolbar.setTitle("");
        toolbarText.setText("Log in");
        

        username = findViewById(R.id.username);
        pass = findViewById(R.id.password);
    }

    public void logIn(View view) {
        startActivity(new Intent(MainActivity.this, ViewPatient.class));
    }
}
