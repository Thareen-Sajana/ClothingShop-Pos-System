package org.icet.demo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.icet.demo.entity.*;

public class HibernateUtil {

    private static SessionFactory sessionFactory = createSession();

    private static SessionFactory createSession() {
        StandardServiceRegistry build =  new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata =  new MetadataSources(build)
                .addAnnotatedClass(UserEntity.class)
                .addAnnotatedClass(ProductEntity.class)
                .addAnnotatedClass(AuthenticationEntity.class)
                .addAnnotatedClass(MeasurmentEntity.class)
                .addAnnotatedClass(OrderDetailsEntity.class)
                .addAnnotatedClass(OrderEntity.class)
                .addAnnotatedClass(SupplierEntity.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();
        return metadata.getSessionFactoryBuilder().build();
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }
}
