package com.tfs.assignmentno3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {


    EditText mEditTextEmail;
    EditText mEditTextCnic;
    EditText mEditTextProvince;
    SharedPreferences mSharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();
    }

    private void init() {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences
                (this);
        mEditTextEmail = (EditText) findViewById(R.id.Setting_editText_Email);
        mEditTextCnic = (EditText) findViewById(R.id.Setting_editText_Cnic);
        mEditTextProvince= (EditText) findViewById(R.id.Setting_editText_Province);
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void savePreferences() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("key_email", mEditTextEmail.getText().toString());
        editor.putString("key_cnic", mEditTextCnic.getText().toString());
        editor.putString("key_province", mEditTextProvince.getText().toString());
        editor.commit();
    }

    private boolean isValidate() {
        if (mEditTextEmail.getText().toString().equalsIgnoreCase("")) {
            showMessage("Please Enter your Email");
            return false;
        } else if (mEditTextCnic.getText().toString().equalsIgnoreCase("")) {
            showMessage("Please Enter your Cnic");
            return false;
        } else if (mEditTextProvince.getText().toString().equalsIgnoreCase("")) {
            showMessage("Please Enter your province");
            return false;
        }
        return true;
    }

    public void onClick_save(View view) {
        if (isValidate()) {
            savePreferences();
            showMessage("Thank You");
        }
    }

    public void onClick_View(View view)
    {
        Intent intent = new Intent(this,ViewActivity.class);
        startActivity(intent);
    }

}
