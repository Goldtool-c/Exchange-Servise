package application.entity;

import application.entity.impl.Entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Customer implements Entity {
    private String name;
    private String password;
    private Role role;
    private Map balance;
    private List<Check> checks = new ArrayList<>();
    private int id;
    public static final String[] CustomerProperties = {"name", "password", "role", "balance"};
    public int getId()
    {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Map getBalance() {
        return balance;
    }

    public List<Check> getChecks() {
        return checks;
    }
    void setCheck(Check check)
    {
        checks.add(check);
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
        this.checks = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", balance=" + balance +
                ", checks=" + checks +
                ", id=" + id +
                '}';
    }


}
