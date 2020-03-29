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

public class EditInfo extends AppCompatActivity {
    private final AppCompatActivity activity = EditInfo.this;
    String emailFromIntent;
    EditText name, pass, situation, bloodType, height, weight;
    DBAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        TextView toolbarText = findViewById(R.id.toolbar_title);

        toolbar.setTitle("");
        toolbarText.setText("Edit Information");
//-----------init------
        name = findViewById(R.id.edit_username);
        pass = findViewById(R.id.edit_password);
        situation = findViewById(R.id.edit_health);
        bloodType = findViewById(R.id.edit_blood);
        height = findViewById(R.id.edit_height);
        weight = findViewById(R.id.edit_weight);
        ///--------database--------------
        emailFromIntent = getIntent().getStringExtra("email");
        adapter = new DBAdapter(activity);

    }

    public void submit(View view) {
        postDataToSQLite(view);
    }


    public void postDataToSQLite(View view) {
        String nameInput = name.getText().toString();
        String sitInput = situation.getText().toString();
        String heightInput = height.getText().toString();
        String weightInput = weight.getText().toString();
        String bloodInput = bloodType.getText().toString();
        String passInput = pass.getText().toString();

        if (nameInput.isEmpty() && sitInput.isEmpty() && heightInput.isEmpty() && weightInput.isEmpty() &&
                bloodInput.isEmpty() && passInput.isEmpty()) {
            Toast.makeText(this, "Enter the values for all fields", Toast.LENGTH_SHORT).show();
        } else {
            adapter.updateData(emailFromIntent, nameInput, passInput, bloodInput, sitInput, heightInput, weightInput);

            Toast.makeText(this, "Insertion successful", Toast.LENGTH_SHORT).show();
            viewData(view);

        }
    }

    public void viewData(View view) {
        String[] data = adapter.getData(emailFromIntent);
        Intent intent = new Intent(this, ViewPatient.class);
        intent.putExtra("Data", data);
        startActivity(intent);
    }

}
