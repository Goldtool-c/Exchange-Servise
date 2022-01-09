package application.entity;

import application.entity.impl.Entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * Класс Клиент со свойствами <b>name</b>, <b>password</b>, <b>role</b>, <b>balance</b>, <b>reciepts</b>, <b>volumeLimit</b>
 * @author Денис Гладышев
 * @version 1.0*/
public class Customer implements Entity {
    private String name;
    private String password;
    private Role role;
    private Map balance;
    private List<Reciept> reciepts;
    private double volumeLimit;

    /**
     * Метод получения значения поля {@link Customer#volumeLimit}
     * @return Возвращает суммарный объем операций за день*/
    public double getVolumeLimit() {
        return volumeLimit;
    }

    public void setVolumeLimit(double volumeLimit) {
        this.volumeLimit = volumeLimit;
    }
    public void incVolume(double value)
    {
        this.volumeLimit = this.volumeLimit + value;
    }

    private int id;
    public static final String[] CustomerProperties = {"name", "password", "role", "balance"};
    /**
     * Метод получения значения поля {@link Customer#id}
     * @return Возвращает id объекта*/
    public int getId()
    {
        return id;
    }
    /**
     * Метод получения значения поля {@link Customer#role}
     * @return возвращает роль клиента*/
    public Role getRole() {
        return role;
    }

    /**
     * Метод получения значения поля {@link Customer#password}
     * @return Возвращает пароль*/
    public String getPassword() {
        return password;
    }
    /**
     * Метод получения значения поля {@link Customer#name}
     * @return возвращает имя пользователя*/
    public String getName() {
        return name;
    }
    /**
     * Метод получения значения поля {@link Customer#balance}
     * @return Возвращает баланс пользователя*/
    public Map getBalance() {
        return balance;
    }
    /**
     * Метод получения значения поля {@link Customer#reciepts}
     * @return Возвращает чеки опреаций, которые выполнил этот пользователь*/
    public List<Reciept> getReciepts() {
        return reciepts;
    }
    /**
     * Метод пополнения количества элементов {@link Customer#reciepts}
     * @param reciept - чек операции, который принадлежит этому пользователю*/
    void setCheck(Reciept reciept)
    {
        reciepts.add(reciept);
    }
    @Override
    public String[] getProps()
    {
        //"name", "password", "role", "balance"
        //RUBLE, DOLLAR, YUAN;
        String[] props = new String[4];
        props[0] =""+getName();
        props[1] =""+getPassword();
        props[2] =""+getRole();
        props[3] ="RUBBLE "+balance.get("RUBBLE")+"|"+"DOLLAR "+balance.get("DOLLAR")+"|"+"YUAN "+balance.get("YUAN");
        return props;
    }

    @Override
    public String[] getPropsNames() {
        return CustomerProperties;
    }

    Customer(String name, String password, Map balance, Role role, int id) {
        this.name = name;
        this.role = role;
        this.password = password;
        this.balance = balance;
        this.id = id;
        this.reciepts = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", balance=" + balance +
                ", reciepts=" + reciepts +
                ", id=" + id +
                '}';
    }


}
