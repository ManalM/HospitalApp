package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hospital.database.DatabaseHelper;
import com.example.hospital.database.InputValidation;
import com.example.hospital.database.User;

import java.util.ArrayList;

public class AddPatient extends AppCompatActivity {
    private final AppCompatActivity activity = AddPatient.this;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;
    EditText email,name,pass,confirmPass,situation,bloodType,height,weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
   //-----------------toolbar----
        Toolbar  toolbar = (Toolbar)findViewById(R.id.tool);
        TextView toolbarText =findViewById(R.id.toolbar_title);

        toolbar.setTitle("");
        toolbarText.setText("Add new patient");
//-----------init------
        email= findViewById(R.id.add_email);
        name = findViewById(R.id.add_username);
        pass= findViewById(R.id.add_password);
        confirmPass = findViewById(R.id.add_confirm_password);
        situation= findViewById(R.id.add_health);
        bloodType= findViewById(R.id.add_blood);
        height= findViewById(R.id.add_height);
        weight= findViewById(R.id.add_weight);
        ///--------database--------------
        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        user = new User();
    }

    public void registerAppointment(View view) {

        postDataToSQLite();
    }
    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(name)) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(email)) {
            return;
        }

        if (!inputValidation.isInputEditTextFilled(pass)) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(pass, confirmPass
               )) {
            return;
        }

        if (!databaseHelper.checkUser(email.getText().toString().trim())) {

            user.setName(name.getText().toString().trim());
            user.setEmail(email.getText().toString().trim());
            user.setPassword(pass.getText().toString().trim());
            user.setBloodType(bloodType.getText().toString().trim());
            user.setSituation(situation.getText().toString().trim());
            user.setHeight(height.getText().toString().trim());
            user.setWeight(weight.getText().toString().trim());
            databaseHelper.addUser(user);

            // Snack Bar to show success message that record saved successfully
            Toast.makeText(activity, "patient registered successfully", Toast.LENGTH_SHORT).show();
        //    emptyInputEditText();
           Intent intent=new Intent(activity,ViewPatient.class);
           intent.putExtra("email",email.getText().toString());
            startActivity(intent);
        } else {
            // Snack Bar to show error message that record already exists
            Toast.makeText(activity, "patient registered field", Toast.LENGTH_SHORT).show();
        }


    }

    /**
     * This method is to empty all input edit text
     */
/*    private void emptyInputEditText() {
        textInputEditTextName.setText(null);
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
        textInputEditTextConfirmPassword.setText(null);
    }*/
}
