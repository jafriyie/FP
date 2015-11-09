package com.bsystemslimited.flexpay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hecatonchries on 11/6/2015.
 */
class PaymentCardsList_Adapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<PaymentCardObject> objects;

    private class ViewHolder{
        TextView txtMobileNetwork;
        TextView txtMobileNumber;
        TextView txtBalance;
    }

    PaymentCardsList_Adapter(Context context, ArrayList<PaymentCardObject> objects) {
        inflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    public int getCount() { return objects.size(); }

    public PaymentCardObject getItem(int position){
        return objects.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.payment_list_view_row,null);
            holder.txtMobileNetwork = (TextView)convertView.findViewById(R.id.etPaymentCardList_MobileNetwork);
            holder.txtMobileNumber = (TextView)convertView.findViewById(R.id.etPaymentCardList_MobileNumber);
            holder.txtBalance = (TextView)convertView.findViewById(R.id.etPaymentCardList_Balance);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.txtMobileNetwork.setText(objects.get(position).getMobileNetwork());
        holder.txtMobileNumber.setText(objects.get(position).getMobileNumber());
        holder.txtBalance.setText(objects.get(position).getBalance());

        return convertView;

    }
}
