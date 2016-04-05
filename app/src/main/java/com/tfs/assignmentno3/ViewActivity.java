package com.tfs.assignmentno3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ViewActivity extends AppCompatActivity {


    TextView mTextViewEmail;
    TextView mTextViewCnic;
    TextView mTextViewProvince;
    SharedPreferences mSharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        init();
        populate();
    }


    private void init() {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mTextViewEmail = (TextView) findViewById(R.id.View_textView_Email);
        mTextViewCnic = (TextView) findViewById(R.id.View_textView_Cnic);
        mTextViewProvince= (TextView) findViewById(R.id.View_textView_Province);
    }

    private void populate() {
        String strName = mSharedPreferences.getString("key_email", "");
        String strPhone = mSharedPreferences.getString("key_cnic", "");
        String strMessage = mSharedPreferences.getString("key_province", "");
        mTextViewEmail.setText(strName);
        mTextViewCnic.setText(strPhone);
        mTextViewProvince.setText(strMessage);
    }

    public void onClick_EditSettings(View view)
    {
        Intent intent = new Intent(this,SettingActivity.class);
        startActivity(intent);
    }
}
