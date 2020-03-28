package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hospital.database.DatabaseHelper;
import com.example.hospital.database.User;

public class ViewPatient extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private AppCompatActivity activity = ViewPatient.this;
    TextView name, situation, bloodType, height, weight;
    String emailFromIntent;
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
        databaseHelper = new DatabaseHelper(activity);
        getDataFromSQLite();
        //-----------------------------------------
        emailFromIntent = getIntent().getStringExtra("email");

    }

    public void Edit(View view) {
        Intent accountsIntent = new Intent(activity, EditInfo.class);
        accountsIntent.putExtra("email", emailFromIntent);
        startActivity(accountsIntent);
    }
//todo:error in retrieve search google
    private void getDataFromSQLite() {
        try {
            if (databaseHelper.checkUser(emailFromIntent)) {

                User user = databaseHelper.getUser(emailFromIntent);
            name.setText(emailFromIntent);
            situation.setText(user.getSituation());
            bloodType.setText(user.getBloodType());
            height.setText(user.getHeight());
            weight.setText(user.getWeight());}
            else{
                Toast.makeText(activity, "error", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(activity, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
