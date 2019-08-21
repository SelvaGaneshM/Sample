package com.selvaganesh.dependencyjar;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.selvaganesh.mysamplelib.MainActivity;

public class MainData extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        startActivity(new Intent(this, MainActivity.class));

    }
}
