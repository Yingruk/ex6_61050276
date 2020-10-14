/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdb;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author Beer
 */
public class StudentDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //insert
      //  Student stu1 = new Student(1, "John", 3.75);
      // Student stu2 = new Student(2, "Marry", 1.36);
       //StudentTable.insertStudent(stu1);
      // StudentTable.insertStudent(stu2);
      //update
      // Student stu3 = new Student(2, "Marry", 3.2);
      // StudentTable.updateStudent(stu3);
      //delete
       Student stu3 = new Student(2, "Marry", 3.2);
       StudentTable.removeStudent(stu3);
      
       List<Student> stuList = StudentTable.findAllStudent();
       printAllStudent(stuList);
        
    }

    public static void printAllStudent(List<Student> studentList) {
        for(Student emp : studentList) {
           System.out.print(emp.getId() + " ");
           System.out.print(emp.getName() + " ");
           System.out.println(emp.getGpa() + " ");
       }
    }
    
     public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentDBPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    
   
}
