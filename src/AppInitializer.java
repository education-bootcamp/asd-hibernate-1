import org.hibernate.Session;

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
