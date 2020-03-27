package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EditInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        Toolbar toolbar = (Toolbar)findViewById(R.id.tool);
        TextView toolbarText =findViewById(R.id.toolbar_title);

        toolbar.setTitle("");
        toolbarText.setText("Edit Information");

    }

    public void submit(View view) {
    }
}
