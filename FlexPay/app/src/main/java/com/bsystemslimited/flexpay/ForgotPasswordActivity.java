package com.bsystemslimited.flexpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgotPasswordActivity extends AppCompatActivity {

    Button nextForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        nextForgot = (Button) findViewById(R.id.bForgotNext);

        nextForgot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ForgotPasswordActivity.this, ForgotActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
