package application.entity;


import application.entity.impl.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Check implements Entity {
    public static final String[] properties = {"date","cashierName", "customerName", "customerCurrency","bankCurrency", "customerCurrencyValue","id"};
    private Date date;
    private String cashierName;
    private String customerName;
    private CurrencyType customerCurrency;
    private CurrencyType bankCurrency;
    private double customerCurrencyValue;
    private int id;

    public Date getDate() {
        return date;
    }

    public String getCashierName() {
        return cashierName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public CurrencyType getCustomerCurrency() {
        return customerCurrency;
    }

    public double getCustomerCurrencyValue() {
        return customerCurrencyValue;
    }

    public CurrencyType getBankCurrency() {
        return bankCurrency;
    }

    public int getId() {
        return id;
    }

    Check(Date date, String cashierName, String customerName, CurrencyType customerCurrency, CurrencyType bankCurrency, Double value, int id)
    {
        this.date = date;
        this.cashierName = cashierName;
        this.customerName = customerName;
        this.customerCurrency = customerCurrency;
        this.bankCurrency = bankCurrency;
        this.id = id;
        this.customerCurrencyValue = value;
    }

    @Override
    public String[] getProps() {
        String[] props = new String[7];
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        props[0] = format.format(date);
        props[1] = cashierName;
        props[2] = customerName;
        props[3] = customerCurrency.toString();
        props[4] = bankCurrency.toString();
        props[5] = ""+customerCurrencyValue;
        props[6] = ""+id;
        return props;
    }

    @Override
    public String[] getPropsNames() {
        String[] props = new String[7];
        props[0] = "date";
        props[1] = "cashierName";
        props[2] = "customerName";
        props[3] = "customerCurrency";
        props[4] = "bankCurrency";
        props[5] = "customerCurrencyValue";
        props[6] = "id";
        return props;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        return "Check{" +
                "date=" + format.format(date) +
                ", cashierName='" + cashierName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerCurrency=" + customerCurrency +
                ", bankCurrency=" + bankCurrency +
                ", customerCurrencyValue=" + customerCurrencyValue +
                ", id=" + id +
                '}';
    }
}
