package application.criteria;

/**
 * Класс Criteria со свойствами <b>property</b>, <b>value</b>.
 * @author Гладышев Денис
 * @version 1.0
 */
public class Criteria {
    private String property;
    private String value;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param property - свойство
     * @param value - значение
     */
    public Criteria(String property, String value)
    {
        this.property = property;
        this.value = value;
    }
    /**
     * Функция получения значения поля {@link Criteria#property}
     * @return возвращает свойство
     * */
    public String getProperty() {
        return property;
    }
    /**
     * Функция получения значения поля {@link Criteria#value}
     * @return возвращает значение
     * */
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "property='" + property + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
