package com.bsystemslimited.flexpay;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Random;
import java.util.regex.Pattern;


public class RegisterActivity extends Activity {

    //Initializing
    private static String URL = "http://197.159.128.38/FlexPayWebService/FlexPay.svc/SignIn?";

    private InternetChecker inChecker = new InternetChecker(this);
    private MobileDataConnectionDetector mobileData;
    private WiFiDataConnectionDetector wifiData;

    private Boolean isMobileDataAvailable = false;
    private Boolean isWifiAvailable = false;

    //UI Controls
    private ProgressDialog dialog;
    private EditText txtFullName;
    private EditText txtEmailAdd;
    private EditText txtPassword, txtConfPassword;
    private EditText txtPhone;
    private EditText txtSeqAnsOne;
    private Spinner spinner;

    Intent myIntent;
    int VerificationCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Setting Up UI Controls
        txtFullName = (EditText) findViewById(R.id.etFullName);
        txtEmailAdd = (EditText) findViewById(R.id.etEmail);
        txtPassword = (EditText) findViewById(R.id.rPassword);
        txtConfPassword = (EditText) findViewById(R.id.rConPassword);
        txtPhone = (EditText) findViewById(R.id.etPhone);
        txtSeqAnsOne = (EditText) findViewById(R.id.etSQ1);

        spinner = (Spinner) findViewById(R.id.spinQuestion1);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.arrQuestions, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        Button bNext = (Button) findViewById(R.id.bNext);


        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Validations
                if (txtFullName.getText().toString().contentEquals("")) {
                    Toast.makeText(RegisterActivity.this, "Please provide your Fullname.", Toast.LENGTH_SHORT).show();
                }
                else if (!isValidEmail(txtEmailAdd.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Please provide a Valid Email", Toast.LENGTH_SHORT).show();
                }
                else if (txtPassword.getText().toString().contentEquals("")) {
                    Toast.makeText(RegisterActivity.this, "Please provide your Password.", Toast.LENGTH_SHORT).show();
                }
                else if (txtConfPassword.getText().toString().contentEquals("")) {
                    Toast.makeText(RegisterActivity.this, "Please Confirm your Password.", Toast.LENGTH_SHORT).show();
                }
                else if (!txtConfPassword.getText().toString().contentEquals(txtPassword.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Passwords do not match.Please check and retype.", Toast.LENGTH_SHORT).show();
                }
                else if (!isValidPhoneNumber(txtPhone.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Please provide a Valid Phone Number", Toast.LENGTH_SHORT).show();
                }
                else if (txtSeqAnsOne.getText().toString().contentEquals("")) {
                    Toast.makeText(RegisterActivity.this, "Please answer your Selected Security Question.", Toast.LENGTH_SHORT).show();
                }
                //Main Initial Registration Code
                else
                {
                    //Generating Random Number to Text for Verification
                    VerificationCode = GetRandomVerificationCode(1000,9999);

                    myIntent = new Intent(RegisterActivity.this, VerificationActivity.class);


                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setMessage("Congratulations on your First Step to creating a FlexPay Account." +
                            "You will receive an SMS shortly with a 4-Digit Verification Code.Kindly Enter the Exact Digits received on the Next Page.")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    try {

                                        //Send Verification SMS
                                        //sendSMS();

                                        //Sending Values to Code Verification Stage
                                        myIntent.putExtra("key_name_1", txtFullName.getText().toString());
                                        myIntent.putExtra("key_email", txtEmailAdd.getText().toString());
                                        myIntent.putExtra("key_password", txtPassword.getText().toString());
                                        myIntent.putExtra("key_confPassword", txtConfPassword.getText().toString());
                                        myIntent.putExtra("key_phone", txtPhone.getText().toString());
                                        myIntent.putExtra("key_SecQues", spinner.getSelectedItem().toString());
                                        myIntent.putExtra("key_SecAns", txtSeqAnsOne.getText().toString());
                                        //
                                        myIntent.putExtra("key_RandomNumb", VerificationCode);

                                        Toast.makeText(getApplicationContext(),
                                                String.valueOf(VerificationCode), Toast.LENGTH_LONG).show();

                                        startActivity(myIntent);

                                    } catch (Exception e) {

                                    }
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }




            }
        });
    }

    private int GetRandomVerificationCode(int Min,int Max)
    {
        Random r = new Random();
        return r.nextInt(Max - Min + 1) + Min;
    }

    private boolean isValidEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    private boolean isValidPhoneNumber(String phoneNum) {
        Pattern pattern = Patterns.PHONE;
        return pattern.matcher(phoneNum).matches();
    }

    @SuppressWarnings("deprecation")
    private void sendSMS(String phoneNumber, String message) {
        Log.v("phoneNumber", phoneNumber);
        Log.v("MEssage", message);
        PendingIntent pi = PendingIntent.getActivity(this, 0,
                new Intent(this, RegisterActivity.class), 0);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, pi, null);
    }


}
