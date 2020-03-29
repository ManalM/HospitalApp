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


public class AddPatient extends AppCompatActivity {

    DBAdapter adapter;
    EditText email, name, pass, confirmPass, situation, bloodType, height, weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        //-----------------toolbar----
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        TextView toolbarText = findViewById(R.id.toolbar_title);

        toolbar.setTitle("");
        toolbarText.setText("Add new patient");
//-----------init------
        email = findViewById(R.id.add_email);
        name = findViewById(R.id.add_username);
        pass = findViewById(R.id.add_password);
        confirmPass = findViewById(R.id.add_confirm_password);
        situation = findViewById(R.id.add_health);
        bloodType = findViewById(R.id.add_blood);
        height = findViewById(R.id.add_height);
        weight = findViewById(R.id.add_weight);
        ///--------database--------------

        adapter = new DBAdapter(this);
    }

    public void registerAppointment(View view) {

        postDataToSQLite(view);
    }

    public void postDataToSQLite(View view) {
        String nameInput = name.getText().toString();
        String emailInput = email.getText().toString();
        String sitInput = situation.getText().toString();
        String heightInput = height.getText().toString();
        String weightInput = weight.getText().toString();
        String bloodInput = bloodType.getText().toString();
        String passInput = pass.getText().toString();
        String confirmPassInput = confirmPass.getText().toString();

        if (nameInput.isEmpty() && emailInput.isEmpty() && sitInput.isEmpty() && heightInput.isEmpty() && weightInput.isEmpty() &&
                bloodInput.isEmpty() && passInput.isEmpty() && confirmPassInput.isEmpty()) {
            Toast.makeText(this, "Enter the values for all fields", Toast.LENGTH_SHORT).show();
        } else {
           // long id =
            if (passInput.equals(confirmPassInput)) {
                adapter.insertData(nameInput, emailInput, passInput, bloodInput, sitInput, heightInput, weightInput);

                Toast.makeText(this, "Insertion successful", Toast.LENGTH_SHORT).show();
                viewData(view);

            } else {
                Toast.makeText(this, "Password doesn't match", Toast.LENGTH_SHORT).show();

            }
        }
    }

    public void viewData(View view) {
        String[] data = adapter.getData( email.getText().toString());
        Intent intent = new Intent(this, ViewPatient.class);
        intent.putExtra("Data", data);
        startActivity(intent);
    }
}
