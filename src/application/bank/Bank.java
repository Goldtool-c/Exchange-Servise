package application.bank;

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
    public void setDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        try {
            currentDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void setDate(Date date)
    {
        this.currentDate = date;
    }
    public void incDate()
    {
        restoreVault();
        long time = currentDate.getTime();
        time = time + 86400000;
        currentDate.setTime(time);
        volume = 0;
    }
    private void restoreVault()
    {
        vault = new HashMap<>();
        vault.put("RUBBLE", 100000000.0);
        vault.put("DOLLAR", 1000000.0);
        vault.put("YUAN", 1000000.0);
    }
}
