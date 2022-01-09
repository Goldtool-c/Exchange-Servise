package application.bank;

import application.entity.Customer;
import application.storage.PersonStorage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
/**
 * Класс Bank со свойствами <b>vault</b>, <b>currentDate</b>, <b>volume</b>, <b>limit</b>, <b>exchangeRate</b>.
 * @author Гладышев Денис
 * @version 1.0
 */
public enum Bank {
    GENERAL;
    /**Поле хранилище*/
    private HashMap<String, Double> vault;
    /**Поле текущая дата*/
    private Date currentDate;
    /**Поле кол-во операций за сутки*/
    private int volume;
    /**Поле предел обмена в день*/
    private final int limit = 10000;
    /**Поле курса валют*/
    private HashMap<String, Double> exchangeRate;
    /**
     * Функция получения значения поля {@link Bank#exchangeRate}
     * @return возвращает курс валют
     */
    public HashMap<String, Double> getExchangeRate()
    {
        return exchangeRate;
    }
    /**
     * Процедура определения текущей даты {@link Bank#currentDate}
     * @param date - текущая дата
     */
    public void setDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        try {
            currentDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    /**
     * Функция получения значения поля {@link Bank#vault}
     * @return возвращает хранилище
     */
    public HashMap<String, Double> getVault()
    {
        return vault;
    }
    /**
     * Процедура определения текущей даты {@link Bank#currentDate}
     * @param date - текущая дата
     */
    public void setDate(Date date)
    {
        this.currentDate = date;
    }
    /**
     * Функция получения значения поля {@link Bank#volume}
     * @return возвращает кол-во операций за сутки
     */
    public int getVolume() {
        return volume;
    }
    /**
     * Функция получения значения поля {@link Bank#currentDate}
     * @return возвращает текущую дату
     */
    public Date getCurrentDate() {
        return currentDate;
    }
    /**
     * Процедура начала нового рабочего дня в обменнике {@link Bank#currentDate}*/
    public void incDate()
    {
        restoreVault();
        long time = currentDate.getTime();
        time = time + 86400000;
        currentDate.setTime(time);
        setExchangeRate();
        volume = 0;
    }
    /**
     * Процедура инкрементации счетчика операций {@link Bank#volume}
     * */
    public void incVolume()
    {
        volume++;
        final int operationsLimit = 4;
        if(volume>=operationsLimit) {
            volume=0;
            Customer temp;
            for (int i = 0; i < PersonStorage.GENERAL.size(); i++) {
                temp = (Customer) PersonStorage.GENERAL.get(i);
                temp.setVolumeLimit(0.0);
            }
            incDate();
        }
    }
    /**
     * Процедура определения курса валют {@link Bank#exchangeRate}
     */
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
    /**
     * Процедура заполнения хранилища {@link Bank#vault}*/
    private void restoreVault()
    {
        vault = new HashMap<>();
        vault.put("RUBBLE", 100000000.0);
        vault.put("DOLLAR", 1000000.0);
        vault.put("YUAN", 1000000.0);
    }
}
