package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ViewPatient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient);
        Toolbar toolbar = (Toolbar)findViewById(R.id.tool);
        TextView toolbarText =findViewById(R.id.toolbar_title);

        toolbar.setTitle("");
        toolbarText.setText("View Information ");

        //todo:get data
    }

    public void Edit(View view) {
        startActivity(new Intent(ViewPatient.this,EditInfo.class));

    }

    public void Book(View view) {
        startActivity(new Intent(ViewPatient.this,AddPatient.class));

    }
}
