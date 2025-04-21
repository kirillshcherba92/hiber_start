package org.lol;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.lol.entity.*;
import org.lol.util.HiberUtil;

import java.time.LocalDate;

public class MainMAnyToAone {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HiberUtil.createSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                System.out.println("ok");
                Transaction transaction = session.getTransaction();
                transaction.begin();

                UserInfo userInfo = new UserInfo("lol", "lol");

                CompanyEntity companyEntity = session.get(CompanyEntity.class, 4);
                if (companyEntity == null) {
                    companyEntity = new CompanyEntity(null, "pepsi");
                    session.persist(companyEntity);
                }

                UserLol lol = new UserLol(
                        null,
                        "lol",
                        userInfo,
                        new Birthday(LocalDate.of(2000, 01, 01)),
                        Role.USER,
                        companyEntity
                );
                UserLol lol2 = new UserLol(
                        null,
                        "lol2",
                        userInfo,
                        new Birthday(LocalDate.of(2000, 01, 01)),
                        Role.USER,
                        companyEntity
                );
                UserLol lol3 = new UserLol(
                        null,
                        "lol3",
                        userInfo,
                        new Birthday(LocalDate.of(2000, 01, 01)),
                        Role.USER,
                        companyEntity
                );


                session.persist(lol);
                session.persist(lol2);
                session.persist(lol3);

                transaction.commit();

            }
        }
    }
}
