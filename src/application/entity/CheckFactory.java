package application.entity;

import application.criteria.Criteria;
import application.entity.impl.Entity;
import application.entity.impl.Factory;
import application.exception.EntityNotFoundException;
import application.exception.UnknownCurrencyException;
import application.exception.UnknownRoleException;
import application.search.Search;
import application.storage.CheckStorage;
import application.storage.PersonStorage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public enum CheckFactory implements Factory {
    GENERAL;
    private static int id = 1;
    @Override
    public Entity create(boolean save, String... args) throws UnknownRoleException, UnknownCurrencyException, ParseException{
        //"date","cashierName", "customerName","customerCurrency","bankCurrency","id"
        Date date = getDate(args[0]);
        String cashierName = args[1];
        String customerName = args[2];
        CurrencyType customerCurrency = getCurrencyType(args[3]);
        CurrencyType bankCurrency = getCurrencyType(args[4]);
        double value = Double.parseDouble(args[5]);
        Check check = new Check(date, cashierName, customerName, customerCurrency, bankCurrency, value, Integer.parseInt("2"+id));
        if(save)
        {
            CheckStorage.GENERAL.add(check);
            Customer customer = null;
            try {
                customer = (Customer) Search.search(PersonStorage.GENERAL, new Criteria("name", customerName));
            } catch (EntityNotFoundException e) {
                e.printStackTrace();
            }
            if(customer != null) {
                customer.setCheck(check);
            }
        }
        id++;
        return check;
    }
    private Date getDate(String arg) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        return format.parse(arg);
    }
    private CurrencyType getCurrencyType(String arg) throws UnknownCurrencyException {
        switch (arg)
        {
            case "RUBBLE":
            {
                return CurrencyType.RUBBLE;
            }
            case "DOLLAR":
            {
                return CurrencyType.DOLLAR;
            }
            case "YUAN":
            {
                return CurrencyType.YUAN;
            }
            default:
            {
                throw new UnknownCurrencyException("Unknown currency");
            }
        }
    }
}
