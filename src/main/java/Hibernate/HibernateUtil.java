package Hibernate;

import DAO.UserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            URI dbUri = new URI("postgres://bmbuyfombvhmbb:a054e9b87053f0ca368c799022ed8618684cd3949df13ba3aaf86a6ae843bd9a@ec2-54-247-85-251.eu-west-1.compute.amazonaws.com:5432/d79rks0b7v2fuu");

            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath() + "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
            Map<String, String> settings = new HashMap<>();
            settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.URL, dbUrl);
            settings.put(Environment.USER, username);
            settings.put(Environment.PASS, password);
            settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
            settings.put(Environment.SHOW_SQL, "true");
            registryBuilder.applySettings(settings);
            StandardServiceRegistry registry = registryBuilder.build();
            MetadataSources sources = new MetadataSources(registry);
            sources.addAnnotatedClass(UserEntity.class);
            // Create Metadata
            Metadata metadata = sources.getMetadataBuilder().build();

            // Create SessionFactory

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

}
