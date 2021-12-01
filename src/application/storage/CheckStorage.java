package application.storage;

import application.entity.Check;
import application.entity.impl.Entity;
import application.storage.impl.Storage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public enum CheckStorage implements Storage {
    GENERAL;
    private List<Entity> checks = new ArrayList<>();

    @Override
    public void add(Entity check) {
        checks.add(check);
    }

    @Override
    public List getStorage() {
        return checks;
    }

    @Override
    public int size() {
        return checks.size();
    }

    @Override
    public Entity get(int i) {
        return checks.get(i);
    }
}
