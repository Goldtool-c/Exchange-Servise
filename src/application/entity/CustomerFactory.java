package application.entity;

import application.entity.impl.Entity;
import application.entity.impl.Factory;
import application.exception.UnknownCurrencyException;
import application.exception.UnknownRoleException;
import application.storage.PersonStorage;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
/**
 * Класс Фабрика клиентов со свойствами <b>id</b>
 * @author Денис Глдаышев
 * @version 1.0*/
public enum CustomerFactory implements Factory {
    INSTANCE;
    //private String name;
    //private String password;
    //private Role role;
    //private Map balance;
    //private List<Reciept> checks;
    private static int id = 1;
    @Override
    public Entity create(boolean save, String... args) throws UnknownRoleException, UnknownCurrencyException, ParseException {
        //args = {"name", "password", "role", "balance"};
        String name = args[0];
        String password = args[1];
        Role role = getRole(args[2], name);
        Map<String, Double> balance = getBalance(args[3], name);
        int i = Integer.parseInt("1"+id);
        Entity person = new Customer(name, password, balance, role, i);
        id++;
        if(save)
        {
            PersonStorage.GENERAL.add(person);
        }
        return person;
    }
    /**
     * Метод преобразования роли из строки в {@link Role}
     * @param role - строковое представление роли
     * @param name - имя создаваемого объекта
     * @return возвращает роль в формате {@link Role}*/
    private Role getRole(String role, String name) throws UnknownRoleException {
        switch (role)
        {
            case "ADMIN":
            {
                return Role.ADMIN;
            }
            case "CUSTOMER":
            {
                return Role.CUSTOMER;
            }
            default:
            {
                throw new UnknownRoleException("Unknown role {name = " + name);
            }
        }
    }
    /**
     * Метод преобразования баланса из строки в {@link Map}
     * @param balance - строковое представление баланса
     * @param name - имя создаваемого объекта
     * @return возвращает роль в формате {@link Map}*/
    private Map<String, Double> getBalance(String balance, String name)
    {
        String []element;
        Map<String, Double> result = new HashMap<>();
        //разделитель для баланса в перспективе будет хранится в properties
        char separator = '|';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < balance.length(); i++) {
            if(balance.charAt(i)!=separator)
            {
                sb.append(balance.charAt(i));
            } else
            {
                element = stringToElement(sb.toString());
                result.put(element[0], Double.parseDouble(element[1]));
                sb = new StringBuilder();
            }
        }
        element = stringToElement(sb.toString());
        result.put(element[0], Double.parseDouble(element[1]));
        return result;
    }
    /**
     * Метод разделения строки на 2 параметра для дальнейшего преобразования
     * @param str - строка, содержащая 2 параметра
     * @return Возвращает массив с разделенными параметрами*/
    private String[] stringToElement(String str)
    {
        String []element = new String[2];
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < str.length())
        {
            if(str.charAt(i)!=' ')
            {
                sb.append(str.charAt(i));
            }
            else
            {
                element[0] = sb.toString();
                i++;
                break;
            }
            i++;
        }
        sb = new StringBuilder();
        while (i<str.length())
        {
            sb.append(str.charAt(i));
            i++;
        }
        element[1] = sb.toString();
        return element;
    }
}
