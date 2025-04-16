package org.lol;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.lol.entity.Birthday;
import org.lol.entity.Role;
import org.lol.entity.UserInfo;
import org.lol.entity.UserLol;
import org.lol.util.HiberUtil;

import java.time.LocalDate;

public class MainLifeCicle {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("Petr", "Petrovich");
        UserLol user1 = new UserLol(
                "Petrov2",
                userInfo,
                new Birthday(LocalDate.of(2004, 01, 01)),
                Role.ADMIN
        );

        try (SessionFactory sessionFactory = HiberUtil.createSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.getTransaction();
                transaction.begin();

//                final UserLol userLol = session.get(UserLol.class, "lol");

                session.persist(user1);
//                session.flush();

                userInfo.setFirstname("Anna");
                session.merge(user1);

//                session.refresh(user1);
                transaction.commit();

            }
        }
    }
}
