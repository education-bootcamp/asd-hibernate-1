import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {
    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    static {
        try {
            if (sessionFactory == null) {
                StandardServiceRegistryBuilder standardServiceRegistryBuilder
                        = new StandardServiceRegistryBuilder();
                Map<String, String> databaseConfiguration = new HashMap<>();
                databaseConfiguration.put(Environment.URL,
                        "jdbc:mysql://localhost:3306/asd_1?createDatabaseIfNotExist=true");
                databaseConfiguration.put(Environment.USER, "root");
                databaseConfiguration.put(Environment.PASS, "1234");
                databaseConfiguration.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                databaseConfiguration.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57Dialect");
                standardServiceRegistryBuilder.applySettings(databaseConfiguration);

                standardServiceRegistry
                        = standardServiceRegistryBuilder.build();
                MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
                Metadata metadata = metadataSources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }
        } catch (Exception e) {
            if (standardServiceRegistry != null) {
                StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
            }
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
