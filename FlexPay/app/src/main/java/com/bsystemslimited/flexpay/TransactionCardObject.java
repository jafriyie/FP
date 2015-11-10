package com.bsystemslimited.flexpay;

/**
 * Created by Hecatonchries on 11/9/2015.
 */
public class TransactionCardObject {

    private int TransactionCardObjectId;
    private String SenderAccount;
    private String RecipientAccount;
    private String DateOfTransaction;
    private String MoneyTransfered;

    public TransactionCardObject(int TransactionCardObjectId,String SenderAccount, String RecipientAccount,String DateOfTransaction,String MoneyTransfered)
    {
        this.TransactionCardObjectId = TransactionCardObjectId;
        this.SenderAccount = SenderAccount;
        this.RecipientAccount = RecipientAccount;
        this.MoneyTransfered = MoneyTransfered;
        this.DateOfTransaction = DateOfTransaction;
    }

    public int getTransactionCardObjectId() { return TransactionCardObjectId; }
    public String getSenderAccount() { return SenderAccount; }
    public String getRecipientAccount() { return RecipientAccount; }
    public String getMoneyTransfered() { return MoneyTransfered; }
    public String getDateOfTransaction() { return DateOfTransaction; }

}
