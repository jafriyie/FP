package com.bsystemslimited.flexpay;

/**
 * Created by Hecatonchries on 11/6/2015.
 */
public class PaymentCardObject {

    private int PaymentAccountId;
    private String MobileNetwork;
    private String MobileNumber;
    private String Balance;

    public PaymentCardObject(int PaymentAccountId,String MobileNetwork, String MobileNumber,String Balance)
    {
        this.PaymentAccountId = PaymentAccountId;
        this.MobileNetwork = MobileNetwork;
        this.MobileNumber = MobileNumber;
        this.Balance = Balance;
    }

    public int getPaymentAccountId() { return PaymentAccountId; }
    public String getMobileNetwork() { return MobileNetwork; }
    public String getMobileNumber() { return MobileNumber; }
    public String getBalance() { return Balance; }
}
