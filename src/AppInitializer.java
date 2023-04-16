import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class AppInitializer {
    public static void main(String[] args) {
        Student student = new Student(1, "Namal", 40);
        //saveStudent(student);
        //findStudent(1);
        findAllStudents();
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
    private static void findAllStudents(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM Student"); // HQL (Hibernate Query Language)
            List<Student> students = query.list();
            System.out.println(students);
        }
    }
}
