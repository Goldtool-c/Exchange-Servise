package application.bank;

import application.entity.Customer;
import application.storage.PersonStorage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public enum Bank {
    GENERAL;
    private HashMap<String, Double> vault;
    private Date currentDate;
    private int volume;
    private final int limit = 10000;
    private HashMap<String, Double> exchangeRate;
    public HashMap<String, Double> getExchangeRate()
    {
        return exchangeRate;
    }
    public void setDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        try {
            currentDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public HashMap<String, Double> getVault()
    {
        return vault;
    }
    public void setDate(Date date)
    {
        this.currentDate = date;
    }
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void incDate()
    {
        restoreVault();
        long time = currentDate.getTime();
        time = time + 86400000;
        currentDate.setTime(time);
        setExchangeRate();
        volume = 0;
    }
    public void incVolume()
    {
        volume++;
        final int operationsLimit = 4;
        if(volume>=operationsLimit) {
            volume=0;
            Customer temp;
            for (int i = 0; i < PersonStorage.GENERAL.size(); i++) {
                temp = (Customer) PersonStorage.GENERAL.get(i);
                temp.setVolume(0.0);
            }
            incDate();
        }
    }
    private void setExchangeRate()
    {
        //(Math.random() * ((max - min) + 1)) + min
        double dollar = (Math.random() * ((2600 - 2400) + 1)) + 2400;
        double rubble = (Math.random() * ((35 - 33) + 1)) + 33;
        double yuan = (Math.random() * ((400 - 380) + 1)) + 380;
        exchangeRate = new HashMap<>();
        exchangeRate.put("Rubble", rubble);
        exchangeRate.put("Dollar", dollar);
        exchangeRate.put("Yuan", yuan);
    }
    private void restoreVault()
    {
        vault = new HashMap<>();
        vault.put("RUBBLE", 100000000.0);
        vault.put("DOLLAR", 1000000.0);
        vault.put("YUAN", 1000000.0);
    }
}
