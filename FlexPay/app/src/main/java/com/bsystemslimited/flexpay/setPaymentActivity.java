package com.bsystemslimited.flexpay;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;

public class setPaymentActivity extends Activity {

    private static String URL = "http://10.0.0.104:70/flexpay/v1/user";

    //UI Controls
    private ProgressDialog dialog;
    Bundle bundle;
    private EditText txtPaymentACNumber;
    private Spinner spinnerMobNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_payment);

        spinnerMobNetwork = (Spinner) findViewById(R.id.spinMoneyNetwork);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.arrMobMoney, R.layout.spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerMobNetwork.setAdapter(adapter);

        //Setting Up UI Controls
        txtPaymentACNumber = (EditText) findViewById(R.id.etMoneyNumber);
        Button bCreateAcc =(Button) findViewById(R.id.bCreateAcc);


        bCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(setPaymentActivity.this, DashActivity.class);
                startActivity(myIntent);
            }
        });

    }




    private boolean isValidPhoneNumber(String phoneNum) {
        Pattern pattern = Patterns.PHONE;
        return pattern.matcher(phoneNum).matches();
    }
}
