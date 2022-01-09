package application.entity.impl;
/**
 * Интерфейс Entity
 * @author Денис Гладышев
 * @version 1.0*/
public interface Entity {
    /**
     * Функция получения значений свойств
     * @return массив значений свойств*/
    String[] getProps();
    /**
     * Функция получения названий свойств
     * @return массив названий свойств*/
    String[] getPropsNames();
}
