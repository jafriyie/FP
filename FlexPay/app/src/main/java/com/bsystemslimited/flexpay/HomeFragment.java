package com.bsystemslimited.flexpay;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Jason on 03/11/2015.
 */
public class HomeFragment extends Fragment {

    String[] contextMenuItems = {"New Transaction","View Transactions","Edit Payment Card","Delete Payment Card"};
    String[] TransactionTypes = {"Money Transfer","Pay Merchant"};
    View view;
    TextView welcomeUser,lastLoginDate;
    ListView theList;
    PaymentCardsList_Adapter myAdapter;
    ArrayList<PaymentCardObject> myObjects;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.home_fragment, container, false);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.HomeFragment_Fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();*/

                Intent myIntent = new Intent(getActivity(), CreateNewActivity.class);
                startActivity(myIntent);
            }
        });

        //Initializing Controls
        welcomeUser = (TextView)view.findViewById(R.id.dashoardProfileCard_Username);
        lastLoginDate = (TextView)view.findViewById(R.id.dashoardProfileCard_LastLoginDate);

        welcomeUser.setText("Welcome Kinglsayer Artorias");
        lastLoginDate.setText("Last Login : 12/09/2015");

        myObjects = new ArrayList<PaymentCardObject>();
        //
        myObjects.add(new PaymentCardObject(1, "MTN Mobile Money", "0245558781", "10.00"));
        myObjects.add(new PaymentCardObject(2, "Vodafone Money", "0200395778", "678.23"));
        myObjects.add(new PaymentCardObject(3, "TiGo Cash", "0279058231", "98.01"));
        myObjects.add(new PaymentCardObject(4, "AirTel Money", "0260098998", "1000.90"));

        myAdapter = new PaymentCardsList_Adapter(getActivity(), myObjects);

        theList = (ListView) view.findViewById(R.id.paymentCardsListView);
        registerForContextMenu(theList);
        //
        theList.setAdapter(myAdapter);

        theList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        /*PaymentCardObject selObj = (PaymentCardObject) theList.getAdapter().getItem(position);
                        String details = selObj.getMobileNetwork() + "," + selObj.getMobileNumber() + "," +
                                selObj.getBalance();

                        Toast.makeText(getActivity(), details, Toast.LENGTH_SHORT).show();*/
                    }
                }
        );


        return view;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //Adding to Context Menu Items
        for(int i=0;i<contextMenuItems.length;i++)
        {
            menu.add(contextMenuItems[i].toString());
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int menuItemIndex = item.getItemId();

        PaymentCardObject selObj = (PaymentCardObject) theList.getAdapter().getItem(info.position);

        //Menu Select Item Code
        if (item.getTitle() == "New Transaction") {
            NewTransaction();
        } else if (item.getTitle() == "View Transactions") {
            ViewTransactionsOnCard(selObj);
        } else if (item.getTitle() == "Edit Payment Card") {
            EditPaymentCard(selObj);
        } else if (item.getTitle() == "Delete Payment Card") {
            DeletePaymentCard(selObj);
        }

        return true;
    }



    //New Payment Account
    public void NewPaymentAccount()
    {

    }


    //New Transaction Function
    public void NewTransaction()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("New Transaction")
                .setItems(TransactionTypes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    //View Transactions on Payment Card
    public void ViewTransactionsOnCard(final PaymentCardObject Obj)
    {

    }

    private void EditPaymentCard(PaymentCardObject selObj)
    {
        Intent myIntent = new Intent(getActivity(), EditCardActivity.class);
        startActivity(myIntent);
    }

    //Delete Payment Card Function
    public void DeletePaymentCard(final PaymentCardObject Obj)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Delete Payment Card");
        builder.setMessage("Are you sure you want to Delete the Selected Payment Card ?");

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                try {
                    Toast.makeText(getActivity(), "Not Deleted " + Obj.getMobileNumber(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {

                }
            }
        });
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                try {
                    Toast.makeText(getActivity(), "Deleted " + Obj.getMobileNumber(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {

                }
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
