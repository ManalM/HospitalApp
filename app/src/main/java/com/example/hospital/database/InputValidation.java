package com.example.hospital.database;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class InputValidation {
    private Context context;

    public InputValidation(Context context) {
        this.context = context;
    }

/*    *//**
     * method to check InputEditText filled .
     *
     * @param textInputEditText
     * @param textInputLayout
     * @param message
     * @return
     */
    public boolean isInputEditTextFilled(EditText textInputEditText) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty()) {
           // textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        } else {
            //textInputLayout.setErrorEnabled(false);
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
/*

    *//**
     * method to check InputEditText has valid email .
     *
     * @param textInputEditText
     * @param textInputLayout
     * @param message
     * @return
     *//*
    public boolean isInputEditTextEmail(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }*/

    public boolean isInputEditTextMatches(EditText textInputEditText1, EditText textInputEditText2) {
        String value1 = textInputEditText1.getText().toString().trim();
        String value2 = textInputEditText2.getText().toString().trim();
        if (!value1.contentEquals(value2)) {
            //textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText2);
            return false;
        } else {
         //   textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    /**
     * method to Hide keyboard
     *
     * @param view
     */
    private void hideKeyboardFrom(View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}