package com.bsystemslimited.flexpay;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Jason on 03/11/2015.
 */
public class ProfileFragment extends Fragment {

    View view;
    Button btnEditProfile,btnSaveProfile;
    Button btnResetPassword;
    //
    TextView tvFullname,tvEmailAddress,tvPhoneNumber;
    EditText txtFullname,txtEmailAddress,txtPhoneNumber;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.profile_fragment, container, false);

        //Initializing Controls
        btnEditProfile = (Button)view.findViewById(R.id.profileCard_EditProfile);
        btnSaveProfile = (Button)view.findViewById(R.id.profileCard_SaveProfile);
        btnResetPassword = (Button)view.findViewById(R.id.profileCard_ResetPassword);
        //
        tvFullname = (TextView)view.findViewById(R.id.profileCard_Fullname);
        tvEmailAddress = (TextView)view.findViewById(R.id.profileCard_Email);
        tvPhoneNumber = (TextView)view.findViewById(R.id.profileCard_PhoneNumber);

        txtFullname = (EditText)view.findViewById(R.id.profileCard_txtFullname);
        txtEmailAddress = (EditText)view.findViewById(R.id.profileCard_txtEmail);
        txtPhoneNumber = (EditText)view.findViewById(R.id.profileCard_txtPhoneNumber);
        //
        tvFullname.setText("Kingslayer Artorias");
        tvEmailAddress.setText("kingslayer_artorias@gmail.com");
        tvPhoneNumber.setText("0246789098");
        //
        txtFullname.setText("Kingslayer Artorias");
        txtEmailAddress.setText("kingslayer_artorias@gmail.com");
        txtPhoneNumber.setText("0246789098");

        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtFullname.setVisibility(View.VISIBLE);
                txtEmailAddress.setVisibility(View.VISIBLE);
                txtPhoneNumber.setVisibility(View.VISIBLE);
                btnSaveProfile.setVisibility(View.VISIBLE);
                //
                tvFullname.setVisibility(View.GONE);
                tvEmailAddress.setVisibility(View.GONE);
                tvPhoneNumber.setVisibility(View.GONE);
                btnEditProfile.setVisibility(View.GONE);
            }
        });


        btnSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtFullname.setVisibility(View.GONE);
                txtEmailAddress.setVisibility(View.GONE);
                txtPhoneNumber.setVisibility(View.GONE);
                btnSaveProfile.setVisibility(View.GONE);
                //
                tvFullname.setVisibility(View.VISIBLE);
                tvEmailAddress.setVisibility(View.VISIBLE);
                tvPhoneNumber.setVisibility(View.VISIBLE);
                btnEditProfile.setVisibility(View.VISIBLE);
            }
        });


        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                // Get the layout inflater
                LayoutInflater inflater = getActivity().getLayoutInflater();

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder.setTitle("Reset Password");
                builder.setView(inflater.inflate(R.layout.reset_password_dialog, null))
                        // Add action buttons
                        .setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // Reset Password
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();

            }
        });


        return view;
    }
}
