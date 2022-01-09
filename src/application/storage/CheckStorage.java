package application.storage;

import application.entity.impl.Entity;
import application.storage.impl.Storage;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс репозиторий для хранения чеков операций <b>checks</b>
 * @author Денис Гладышев
 * @version 1.0*/
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
