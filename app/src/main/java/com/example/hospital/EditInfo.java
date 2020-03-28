package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hospital.database.DatabaseHelper;
import com.example.hospital.database.InputValidation;
import com.example.hospital.database.User;

public class EditInfo extends AppCompatActivity {
    private final AppCompatActivity activity = EditInfo.this;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;
    EditText email, name, pass, situation, bloodType, height, weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        TextView toolbarText = findViewById(R.id.toolbar_title);

        toolbar.setTitle("");
        toolbarText.setText("Edit Information");
//-----------init------
        email = findViewById(R.id.edit_email);
        name = findViewById(R.id.edit_username);
        pass = findViewById(R.id.edit_password);
        situation = findViewById(R.id.edit_health);
        bloodType = findViewById(R.id.edit_blood);
        height = findViewById(R.id.edit_height);
        weight = findViewById(R.id.edit_weight);
        ///--------database--------------
        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        user = new User();
    }

    public void submit(View view) {
        postDataToSQLite();
    }

    private void postDataToSQLite() {
/*        if (!inputValidation.isInputEditTextFilled(bloodType)) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(email)) {
            return;
        }

        if (!inputValidation.isInputEditTextFilled(pass)) {
            return;
        }*/
        String emailFromIntent = getIntent().getStringExtra("email");

        if (databaseHelper.checkUser(emailFromIntent)) {

            user.setName(name.getText().toString().trim());
            user.setEmail(email.getText().toString().trim());
            user.setPassword(pass.getText().toString().trim());
            user.setBloodType(bloodType.getText().toString().trim());
            user.setSituation(situation.getText().toString().trim());
            user.setHeight(height.getText().toString().trim());
            user.setWeight(weight.getText().toString().trim());
            databaseHelper.updateUser(user);

            // Snack Bar to show success message that record saved successfully
            Toast.makeText(activity, "patient info updated successfully", Toast.LENGTH_SHORT).show();
            //    emptyInputEditText();
            Intent intent=new Intent(activity,ViewPatient.class);
            intent.putExtra("email",email.getText().toString());
            startActivity(intent);
        } else {
            // Snack Bar to show error message that record already exists
            Toast.makeText(activity, "patient info updated field", Toast.LENGTH_SHORT).show();
        }


    }

}
