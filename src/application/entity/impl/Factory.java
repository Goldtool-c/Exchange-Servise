package application.entity.impl;

import application.exception.UnknownCurrencyException;
import application.exception.UnknownRoleException;

import java.text.ParseException;
/**
 * Интерфейс Factory
 * @author Денис Гладышев
 * @version 1.0*/
public interface Factory {
    /**
     * Метод создания {@link Entity}
     * @param save - определяет, сохранять ли {@link Entity} в {@link application.storage.impl.Storage}
     * @return возвращает новый объект {@link Entity}*/
    Entity create(boolean save, String ...args) throws UnknownRoleException, UnknownCurrencyException, ParseException;
}
