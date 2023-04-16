import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.Map;

public class AppInitializer {
    public static void main(String[] args) {
        printMySQlVersion();
        printMySQlDateAndTime();
    }

    private static void printMySQlVersion(){
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            Object result =
                    session.createNativeQuery("SELECT VERSION()").getSingleResult();
            System.out.println(result);
        }
    }
    private static void printMySQlDateAndTime(){
        try(Session session=  HibernateUtil.getSessionFactory().openSession()){
            Object result =
                    session.createNativeQuery("SELECT NOW()").getSingleResult();
            System.out.println(result);
        }
    }

}
