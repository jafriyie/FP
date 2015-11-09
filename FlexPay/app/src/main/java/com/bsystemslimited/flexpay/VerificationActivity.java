package com.bsystemslimited.flexpay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VerificationActivity extends Activity {

    private int VerificationCode;
    private String EnteredCode;
    private EditText txtVerification;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        //Getting Intent Variables
        bundle = getIntent().getExtras();
        VerificationCode = bundle.getInt("key_RandomNumb");

        txtVerification = (EditText) findViewById(R.id.etVerif);

        Button bVerify = (Button) findViewById(R.id.bVerify);


        bVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (txtVerification.getText().toString().contentEquals(String.valueOf(VerificationCode))) {

                    Intent myIntent = new Intent(VerificationActivity.this, setPaymentActivity.class);

                    myIntent.putExtra("key_name", bundle.getString("key_name_1"));
                    myIntent.putExtra("key_email", bundle.getString("key_email"));
                    myIntent.putExtra("key_password", bundle.getString("key_password"));
                    myIntent.putExtra("key_confPassword", bundle.getString("key_confPassword"));
                    myIntent.putExtra("key_phone", bundle.getString("key_phone"));
                    myIntent.putExtra("key_SecQues", bundle.getString("key_SecQues"));
                    myIntent.putExtra("key_SecAns", bundle.getString("key_SecAns"));
                    myIntent.putExtra("key_VerificationCode",txtVerification.getText().toString());

                    startActivity(myIntent);

                }else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(VerificationActivity.this);
                    builder.setMessage("Verification Code entered does not match.Please check and retype.")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //do things
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }


            }
        });

    }


}
