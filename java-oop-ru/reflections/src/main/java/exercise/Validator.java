package exercise;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Object obj) {
        List<String> resultList = new LinkedList<>();
        Class<?> aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                if (field.isAnnotationPresent(NotNull.class) & value == null) {
                    resultList.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return resultList;
    }
}
