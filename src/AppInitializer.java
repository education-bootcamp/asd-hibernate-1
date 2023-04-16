import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

public class AppInitializer {
    public static void main(String[] args) {
        Student student = new Student(1, "Jayantha", 50);
        saveStudent(student);
        //findStudent(1);
    }

    private static void saveStudent(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // save[it returns a serializable object, saved object primary key]
            // persist [void]
            // saveOrUpdate
            Transaction transaction = session.beginTransaction(); // save, update, delete
            session.save(student);
            transaction.commit();
        }
    }
    private static void findStudent(long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Student student = session.find(Student.class,id);
            if (student!=null){
                System.out.println(student.toString());
            }else{
                System.out.println("Can\'t find data");
            }

        }
    }
}
