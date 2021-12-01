package application.search;

import application.criteria.Criteria;
import application.entity.impl.Entity;
import application.exception.EntityNotFoundException;
import application.storage.impl.Storage;

import java.util.ArrayList;
import java.util.List;

public class Search {
    public static Entity search(Storage storage, Criteria criteria) {
        Entity result = null;
        for (int i = 0; i < storage.size(); i++) {
            if(search(storage.get(i), criteria))
            {
                return storage.get(i);
            }
        }
        System.out.println("There is no entity that matches criteria "+criteria.toString());//todo log.error
        return null;
    }
    private static boolean search(Entity entity, Criteria criteria)
    {
        for (int i = 0; i < entity.getPropsNames().length ; i++) {
            if(criteria.getProperty().equals(entity.getPropsNames()[i]))
            {
                if(criteria.getValue().equals(entity.getProps()[i]))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
