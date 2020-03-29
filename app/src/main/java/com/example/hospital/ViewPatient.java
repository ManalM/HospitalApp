package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ViewPatient extends AppCompatActivity {
    private AppCompatActivity activity = ViewPatient.this;
    TextView name, situation, bloodType, height, weight;
    String emailFromIntent;
    String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        TextView toolbarText = findViewById(R.id.toolbar_title);

        toolbar.setTitle("");
        toolbarText.setText("View Information ");
        //-------------------init------------
        name = findViewById(R.id.name);
        situation = findViewById(R.id.situation);
        bloodType = findViewById(R.id.blood_type);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        //---------------database------------
        getDataFromSQLite();
        //-----------------------------------------
        data = getIntent().getStringArrayExtra("Data");

    }

    public void Edit(View view) {
        Intent accountsIntent = new Intent(activity, EditInfo.class);
        accountsIntent.putExtra("email", data[0]);
        startActivity(accountsIntent);
    }

    private void getDataFromSQLite() {
        if (data != null) {
            name.setText(data[1]);
            bloodType.setText(data[2]);
            height.setText(data[3]);
            weight.setText(data[4]);
            situation.setText(data[5]);

        } else {
            Toast.makeText(activity, "no data for the user", Toast.LENGTH_SHORT).show();
        }


    }
}
