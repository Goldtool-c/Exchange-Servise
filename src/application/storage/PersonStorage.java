package application.storage;

import application.entity.Customer;
import application.entity.impl.Entity;
import application.storage.impl.Storage;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс репозиторий, содержащий хранилище со списком клиентов со свойствами <b>people</b>, <b>user</b>
 * @author Денис Гладышев
 * @version 1.0*/
public enum PersonStorage implements Storage {
    GENERAL;
    private List<Entity> people = new ArrayList<>();
    private Customer user;
    public void add(Entity person)
    {
        people.add(person);
    }
    public List getStorage()
    {
        return people;
    }
    public int size()
    {
        return people.size();
    }
    /**
     * Метод для указания активного пользователя
     * @param user - активный пользователь */
    public void setUser(Customer user) {//todo another class for active user
        this.user = user;
    }
    /**
     * Метод для получения активного пользователя
     * @return активный пользователь*/
    public Customer getUser() {
        return user;
    }

    public Entity get(int i)
    {
        return people.get(i);
    }
}
