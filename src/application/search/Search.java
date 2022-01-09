package application.search;

import application.criteria.Criteria;
import application.entity.impl.Entity;
import application.exception.EntityNotFoundException;
import application.storage.impl.Storage;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс Search
 * @author Денис Гладышев
 * @version 1.0*/
public class Search {
    /**
     * Метод поиска по критерию {@link Criteria}
     * @param criteria - критерий, по которму осуществляется поиск
     * @param storage - репозиторий, в котором осуществляется поиск
     * @return - объект, найденный в storage по criteria*/
    public static Entity search(Storage storage, Criteria criteria) {
        Entity result = null;
        for (int i = 0; i < storage.size(); i++) {
            if(search(storage.get(i), criteria))
            {
                return storage.get(i);
            }
        }
        System.out.println("There is no entity that matches criteria "+criteria.toString());//todo exception
        return null;
    }
    /**
     * Метод установления соответсвия entity criteria {@link Criteria}
     * @param criteria - критерий
     * @param entity - объект, который необходимо проверить на соответствие criteria
     * @return - соответствие объекта критерию */
    private static boolean search(Entity entity, Criteria criteria)
    {
        for (int i = 0; i < entity.getPropsNames().length ; i++) {
            if(criteria.getProperty().equals(entity.getPropsNames()[i]))
            {
                return criteria.getValue().equals(entity.getProps()[i]);
            }
        }
        return false;
    }
}
