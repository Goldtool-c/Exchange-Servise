package application.storage.impl;

import application.entity.impl.Entity;

import java.util.List;
/**
 * Интерфейс Storage
 * описание поведения репозиториев
 * @author Денис Гладышев
 * @version 1.0*/
public interface Storage {
    /**
     * Метод добавления Entity {@link Entity} в репозиторий
     * @param entity - entity, которую необходимо добавить*/
    void add(Entity entity);
    /**
     * Метод получения ссылки на хранилище
     * @return возвращает хранилище*/
    List getStorage();
    /**
     * Метод получения размера хранилища
     * @return размер хранилища*/
    int size();
    /**
     * Метод получения объекта хранилища по индексу
     * @param i - индекс
     * @return объект под номером i+1*/
    Entity get(int i);
}
