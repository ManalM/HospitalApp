package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewPatient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient);

        //todo:get data
    }

    public void Edit(View view) {
        startActivity(new Intent(ViewPatient.this,EditInfo.class));

    }

    public void Book(View view) {
        startActivity(new Intent(ViewPatient.this,AddPatient.class));

    }
}
