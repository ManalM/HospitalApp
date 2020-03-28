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
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private final AppCompatActivity activity = MainActivity.this;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private EditText username, pass;
    private TextView register ;
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
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);
        //-------------init------------------
        username = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        register= findViewById(R.id.register);
        //---------------------------------
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddPatient.class));
            }
        });
    }

    public void logIn(View view) {
        verifyFromSQLite();
    }

    private void verifyFromSQLite() {
        if (!inputValidation.isInputEditTextFilled(username)) {
            return;
        }
      /*  if (!inputValidation.isInputEditTextEmail(username.getText().toString(), textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }*/
        if (!inputValidation.isInputEditTextFilled(pass)) {
            return;
        }

        if (databaseHelper.checkUser(username.getText().toString().trim()
                , pass.getText().toString().trim())) {


            Intent accountsIntent = new Intent(activity, ViewPatient.class);
            accountsIntent.putExtra("email", username.getText().toString().trim());
            emptyInputEditText();
            startActivity(accountsIntent);


        } else {
            Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        username.setText(null);
        pass.setText(null);
    }
}
