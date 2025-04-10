package org.lol;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.lol.converter.BirthdayConverter;
import org.lol.entity.Birthday;
import org.lol.entity.Role;
import org.lol.entity.UserLol;

import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("lol");

        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAttributeConverter(BirthdayConverter.class, true);
//        configuration.addAnnotatedClass(UserLol.class); // Добавляем класс для маппинга на сущность при помощи Java кода

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                System.out.println("ok");
                Transaction transaction = session.getTransaction();
                transaction.begin();

//                UserLol user = new UserLol(
//                        "Bob@Tob",
//                        "Bobov",
//                        "Bob",
//                        new Birthday(LocalDate.of(2000, 01, 01)),
//                        Role.ADMIN
//                );

                UserLol lol = new UserLol("lol", "lol", "lol", new Birthday(LocalDate.of(2000, 01, 01)), Role.USER);
                UserLol lol2 = new UserLol("lol", "lol2", "lol2", new Birthday(LocalDate.of(2000, 01, 01)), Role.USER);

                session.persist(lol);   // Добавить сущность
//                session.merge(lol2);  // Обновить сущность
//                session.remove(lol2); // Удалить сущность
                UserLol userLol = session.get(UserLol.class, "lol");    // Получить сущность
                System.out.println(userLol);

                transaction.commit();
            }
        }


    }
}
