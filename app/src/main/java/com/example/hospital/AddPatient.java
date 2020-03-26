package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddPatient extends AppCompatActivity {
Spinner doctor,times,clinic;
ArrayList<String> doctorName,clinicName,date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        doctor=findViewById(R.id.doctors);
        times=findViewById(R.id.times);
        clinic=findViewById(R.id.clinics);
        //--------------------------------
        doctorName = new ArrayList<>();
        clinicName = new ArrayList<>();
        date = new ArrayList<>();
        //---------------------------------
        doctorName.add("choose your doctor");
        doctorName.add("Dr.Ahmed");
        doctorName.add("Dr.Anwar");
        doctorName.add("Dr.Nouf");

        clinicName.add("choose the clinic");
        clinicName.add("Dental Clinic");
        clinicName.add("Orthopedic clinic");
        clinicName.add("Eye clinic");

        date.add("choose the time");
        date.add("Sunday, 3:15 pm");
        date.add("Monday, 12:30 pm");
        date.add("Friday, 9:15 am");
        //------------------------------------
        times.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                times.animate();
            }
        });
        clinic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                clinic.animate();
            }
        });
        doctor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                doctor.animate();
            }
        });
    }

    public void registerAppointment(View view) {
        times.getSelectedItem();
        clinic.getSelectedItem();
        doctor.getSelectedItem();

    }
}
