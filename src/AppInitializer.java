import entity.Book;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

public class AppInitializer {
    public static void main(String[] args) {
        Student student = new Student(1,"Jayantha",50);
        Book book = new Book(1,"hibernate");
        saveStudent(student);
        saveBook(book);
    }

    private static void saveStudent(Student student){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            // save[it returns a serializable object, saved object primary key]
            // persist,saveOrUpdate
            Transaction transaction = session.beginTransaction(); // save, update, delete
            long primaryKey = (Long) session.save(student);
            transaction.commit();
            System.out.println(primaryKey);
        }
    }
    private static void saveBook(Book book){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            // save[it returns a serializable object, saved object primary key]
            // persist,saveOrUpdate
            Transaction transaction = session.beginTransaction(); // save, update, delete
            long primaryKey = (Long) session.save(book);
            transaction.commit();
            System.out.println(primaryKey);
        }
    }

}
