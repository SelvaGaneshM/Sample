package com.selvaganesh.mysamplelib;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtUserName, edtMobileNumeber, edtState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUserName = (EditText) findViewById(R.id.edtUserName);
        edtMobileNumeber = (EditText) findViewById(R.id.edtMobileNumeber);
        edtState = (EditText) findViewById(R.id.edtState);

    }

    private String getUserNameString() {
        return TextUtils.getString(edtUserName.getText());
    }

    private String getMobileNumberString() {
        return TextUtils.getString(edtUserName.getText());
    }

    private String getStateString() {
        return TextUtils.getString(edtUserName.getText());
    }

    private boolean isAllFieldsFilled() {
        return (!TextUtils.isEmpty(edtUserName.getText().toString()) && !TextUtils.isEmpty(edtMobileNumeber.getText().toString()) && !TextUtils.isEmpty(edtState.getText().toString()));
    }

}
