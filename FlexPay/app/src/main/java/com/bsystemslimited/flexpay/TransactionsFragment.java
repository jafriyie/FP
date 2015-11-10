package com.bsystemslimited.flexpay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jason on 03/11/2015.
 */
public class TransactionsFragment extends Fragment {

    View view;
    ListView theList;
    TransactionCardsList_Adapter myAdapter;
    ArrayList<TransactionCardObject> myObjects;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.transactions_fragment, container, false);

        //Initializing Controls

        //
        myObjects = new ArrayList<TransactionCardObject>();
        //
        myObjects.add(new TransactionCardObject(1, "0245558781", "0200395778","11 Dec 2014", "400.00"));
        myObjects.add(new TransactionCardObject(2, "0200395778", "0245558781","5 Feb 2014", "30.00"));

        myAdapter = new TransactionCardsList_Adapter(getActivity(), myObjects);

        theList = (ListView) view.findViewById(R.id.transactionCardsListView);
        registerForContextMenu(theList);
        //
        theList.setAdapter(myAdapter);

        theList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        );

        return view;
    }
}
