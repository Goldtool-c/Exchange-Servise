package application.storage.impl;

import application.entity.impl.Entity;

import java.util.List;

public interface Storage {
    void add(Entity entity);
    List getStorage();
    int size();
    Entity get(int i);
}
