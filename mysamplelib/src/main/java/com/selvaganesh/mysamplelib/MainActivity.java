package com.selvaganesh.mysamplelib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.selvaganesh.mysamplelibr.R;


public class MainActivity extends AppCompatActivity {

    public EditText edtUserName, edtMobileNumeber, edtState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUserName = (EditText) findViewById(R.id.edtUserName);
        edtMobileNumeber = (EditText) findViewById(R.id.edtMobileNumeber);
        edtState = (EditText) findViewById(R.id.edtState);
        passData();
    }

    private void passData() {


        edtUserName.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                moveToBackData();
            }
        });

        edtMobileNumeber.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                moveToBackData();
            }
        });

        edtState.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                moveToBackData();
            }
        });

    }

    private void moveToBackData() {
        if (!TextUtils.isEmpty(edtUserName.getText().toString())
                && !TextUtils.isEmpty(edtMobileNumeber.getText().toString())
                && !TextUtils.isEmpty(edtState.getText().toString())) {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("result", TextUtils.getString(edtUserName.getText()) + "," + TextUtils.getString(edtMobileNumeber.getText()) + "," + TextUtils.getString(edtState.getText()));
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }
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
