package application.entity;


import application.entity.impl.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/**
 * Класс чек с полями <b>date</b>, <b>cashierName</b>, <b>customerName</b>,
 * <b>customerCurrency</b>, <b>bankCurrency</b>, <b>customerCurrencyValue</b>, <b>bankCurrencyValue</b>, <b>id</b>*/
public class Reciept implements Entity {
    public static final String[] properties = {"date","cashierName", "customerName", "customerCurrency","bankCurrency", "customerCurrencyValue","bankCurrencyValue","id"};
    private Date date;
    private String cashierName;
    private String customerName;
    private CurrencyType customerCurrency;//продано
    private CurrencyType bankCurrency;//приобретено
    private double customerCurrencyValue;
    private double bankCurrencyValue;
    private int id;

    /**
     * Метод получения даты операции
     * @return возвращает метод операции*/
    public Date getDate() {
        return date;
    }

//    public String getCashierName() {
//        return cashierName;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public CurrencyType getCustomerCurrency() {
//        return customerCurrency;
//    }
//
//    public double getCustomerCurrencyValue() {
//        return customerCurrencyValue;
//    }
//
//    public CurrencyType getBankCurrency() {
//        return bankCurrency;
//    }

    public int getId() {
        return id;
    }

//    public double getBankCurrencyValue() {
//        return bankCurrencyValue;
//    }
//
//    public void setBankCurrencyValue(double bankCurrencyValue) {
//        this.bankCurrencyValue = bankCurrencyValue;
//    }
    /**
     * Конструктор
     * @param date - дата проведения операции
     * @param cashierName - имя кассира
     * @param customerName - имя клиента
     * @param customerCurrency - валюта, проданная клиентом
     * @param bankCurrency - валюта, проданная банком
     * @param bankValue - количество валюты, проданное банком
     * @param value - количество валюты, проданное клиентом
     * @param id - уникальный идентификатор операции*/
    Reciept(Date date, String cashierName, String customerName, CurrencyType customerCurrency, CurrencyType bankCurrency, Double value, Double bankValue, int id)
    {
        this.date = date;
        this.cashierName = cashierName;
        this.customerName = customerName;
        this.customerCurrency = customerCurrency;
        this.bankCurrency = bankCurrency;
        this.id = id;
        this.customerCurrencyValue = value;
        this.bankCurrencyValue = bankValue;
    }

    @Override
    public String[] getProps() {
        String[] props = new String[8];
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        props[0] = format.format(date);
        props[1] = cashierName;
        props[2] = customerName;
        props[3] = customerCurrency.toString();
        props[4] = bankCurrency.toString();
        props[5] = ""+customerCurrencyValue;
        props[6] = ""+bankCurrencyValue;
        props[7] = ""+id;
        return props;
    }

    @Override
    public String[] getPropsNames() {
        String[] props = new String[8];
        props[0] = "date";
        props[1] = "cashierName";
        props[2] = "customerName";
        props[3] = "customerCurrency";
        props[4] = "bankCurrency";
        props[5] = "customerCurrencyValue";
        props[6] = "bankCurrencyValue";
        props[7] = "id";
        return props;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        return "Reciept{" +
                "date=" + format.format(date) +
                ", cashierName='" + cashierName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", \ncustomerCurrency=" + customerCurrency +
                ", bankCurrency=" + bankCurrency +
                ", customerCurrencyValue=" + customerCurrencyValue +
                ", id=" + id +
                '}';
    }
}
