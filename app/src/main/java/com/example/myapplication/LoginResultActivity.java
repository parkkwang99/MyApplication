package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginResultActivity extends AppCompatActivity {

    TextView mTextView_get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manu);

        mTextView_get = findViewById(R.id.TextView_get);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        String email = bundle.getString("email");
        String password = bundle.getString("password");

        mTextView_get.setText(email + ", " + password);

    }
}
