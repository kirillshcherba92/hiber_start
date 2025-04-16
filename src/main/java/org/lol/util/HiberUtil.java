package org.lol.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.lol.converter.BirthdayConverter;

public class HiberUtil {

    public static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAttributeConverter(BirthdayConverter.class, true);
//        configuration.addAnnotatedClass(UserLol.class); // Добавляем класс для маппинга на сущность при помощи Java кода

        return configuration.buildSessionFactory();
    }
}
