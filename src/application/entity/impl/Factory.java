package application.entity.impl;

import application.exception.UnknownCurrencyException;
import application.exception.UnknownRoleException;

import java.text.ParseException;

public interface Factory {
    Entity create(boolean save, String ...args) throws UnknownRoleException, UnknownCurrencyException, ParseException;
}
