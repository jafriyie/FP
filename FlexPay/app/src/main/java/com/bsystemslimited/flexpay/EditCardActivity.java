package com.bsystemslimited.flexpay;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditCardActivity extends AppCompatActivity {

    private EditText txtNewACNumber;
    private Spinner spinnerNewMobNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinnerNewMobNetwork = (Spinner) findViewById(R.id.spinNewMoneyNetwork);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.arrMobMoney, R.layout.new_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerNewMobNetwork.setAdapter(adapter);

        //Setting Up UI Controls
        txtNewACNumber = (EditText) findViewById(R.id.etNewMoneyNumber);
        Button bEditAcc =(Button) findViewById(R.id.bEditAcc);

        bEditAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast newAcc = Toast.makeText(EditCardActivity.this, "Changes Saved", Toast.LENGTH_LONG);
                newAcc.show();
                Intent myIntent = new Intent(EditCardActivity.this, DashActivity.class);
                startActivity(myIntent);
            }
        });

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
