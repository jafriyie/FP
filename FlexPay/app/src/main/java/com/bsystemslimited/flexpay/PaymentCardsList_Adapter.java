package com.bsystemslimited.flexpay;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hecatonchries on 11/6/2015.
 */
class PaymentCardsList_Adapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<PaymentCardObject> objects;

    private class ViewHolder{
        TextView txtBalanceHeader;
        TextView txtMobileNetwork;
        TextView txtMobileNumber;
        TextView txtBalance;
        ImageView imgLogo;
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
            //
            holder.txtBalanceHeader = (TextView)convertView.findViewById(R.id.etPaymentCardList_BalanceHeader);
            holder.imgLogo = (ImageView)convertView.findViewById(R.id.etPaymentCardList_ImageLogo);
            //
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

        try {
            if (objects.get(position).getMobileNetwork() == "MTN Mobile Money") {
                //convertView.setBackgroundColor(Color.parseColor("#FFE476"));
                holder.imgLogo.setBackgroundResource(R.mipmap.mtn_logo);
            }
            if (objects.get(position).getMobileNetwork() == "TiGo Cash") {
                /*convertView.setBackgroundColor(Color.parseColor("#4369A9"));
                holder.txtMobileNetwork.setTextColor(Color.parseColor("#FFFFFF"));
                holder.txtMobileNumber.setTextColor(Color.parseColor("#D9D9D9"));
                holder.txtBalanceHeader.setTextColor(Color.parseColor("#D9D9D9"));
                holder.txtBalance.setTextColor(Color.parseColor("#FFFFFF"));*/
                holder.imgLogo.setBackgroundResource(R.mipmap.tigo_logo);
            }
            if (objects.get(position).getMobileNetwork() == "AirTel Money") {
                /*convertView.setBackgroundColor(Color.parseColor("#ED1B24"));
                holder.txtMobileNetwork.setTextColor(Color.parseColor("#FFFFFF"));
                holder.txtMobileNumber.setTextColor(Color.parseColor("#D9D9D9"));
                holder.txtBalanceHeader.setTextColor(Color.parseColor("#D9D9D9"));
                holder.txtBalance.setTextColor(Color.parseColor("#FFFFFF"));*/
                holder.imgLogo.setBackgroundResource(R.mipmap.airtel_logo);
            }
            if (objects.get(position).getMobileNetwork() == "Vodafone Money") {
                //convertView.setBackgroundColor(Color.parseColor("#FFE476"));
                holder.imgLogo.setBackgroundResource(R.mipmap.vodafone_logo);
            }
        }
        catch(Exception e){}

        return convertView;

    }
}
