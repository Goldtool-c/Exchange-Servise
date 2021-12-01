package application.storage;

import application.entity.Customer;
import application.entity.impl.Entity;
import application.storage.impl.Storage;

import java.util.ArrayList;
import java.util.List;

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

    public void setUser(Customer user) {
        this.user = user;
    }

    public Customer getUser() {
        return user;
    }

    public Entity get(int i)
    {
        return people.get(i);
    }
}
