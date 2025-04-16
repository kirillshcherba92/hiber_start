package org.lol;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.lol.converter.BirthdayConverter;
import org.lol.entity.Birthday;
import org.lol.entity.Role;
import org.lol.entity.UserInfo;
import org.lol.entity.UserLol;
import org.lol.util.HiberUtil;

import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("lol");

        try (SessionFactory sessionFactory = HiberUtil.createSessionFactory()) {
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
                UserInfo userInfo = new UserInfo("lol", "lol");
                UserLol lol = new UserLol("lol", userInfo, new Birthday(LocalDate.of(2000, 01, 01)), Role.USER);
                UserLol lol2 = new UserLol("lol", userInfo, new Birthday(LocalDate.of(2000, 01, 01)), Role.USER);

//                session.persist(lol);   // Добавить сущность
//                session.merge(lol2);  // Обновить сущность
//                session.remove(lol2); // Удалить сущность
                UserLol userLol = session.get(UserLol.class, "lol");    // Получить сущность
//                UserLol userLol2 = session.get(UserLol.class, "lol");    // Получить сущность
//                UserLol userLol3 = session.get(UserLol.class, "lol");    // Получить сущность

                userInfo.setFirstname("body3");
                session.flush();
                System.out.println(userLol);
//                System.out.println(userLol2);
//                System.out.println(userLol3);
//                int i = 1/0;  // чисто для ексепшна
                transaction.commit();

            }
        }


    }
}
