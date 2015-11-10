package com.bsystemslimited.flexpay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hecatonchries on 11/9/2015.
 */
public class TransactionCardsList_Adapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<TransactionCardObject> objects;

    private class ViewHolder{
        TextView txtSenderAc;
        TextView txtRecipientAC;
        TextView txtPaymentDate;
        TextView txtAmount;
    }

    TransactionCardsList_Adapter(Context context, ArrayList<TransactionCardObject> objects) {
        inflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    public int getCount() { return objects.size(); }

    public TransactionCardObject getItem(int position){
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
            convertView = inflater.inflate(R.layout.transactions_list_view_row,null);
            //
            holder.txtSenderAc = (TextView)convertView.findViewById(R.id.etTransCardList_SenderAC);
            holder.txtRecipientAC = (TextView)convertView.findViewById(R.id.etTransCardList_RecipientAC);
            holder.txtPaymentDate = (TextView)convertView.findViewById(R.id.etTransCardList_PaymentDate);
            holder.txtAmount = (TextView)convertView.findViewById(R.id.etTransCardList_PaymentAmount);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.txtSenderAc.setText(objects.get(position).getSenderAccount());
        holder.txtRecipientAC.setText(objects.get(position).getRecipientAccount());
        holder.txtPaymentDate.setText(objects.get(position).getDateOfTransaction());
        holder.txtAmount.setText(objects.get(position).getMoneyTransfered());

        return convertView;
    }

}
