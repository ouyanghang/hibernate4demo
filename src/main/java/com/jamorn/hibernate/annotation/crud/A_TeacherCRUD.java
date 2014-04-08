package com.jamorn.hibernate.annotation.crud;

import com.jamorn.hibernate.annotation.entity.Student;
import com.jamorn.hibernate.annotation.entity.Teacher;
import com.jamorn.hibernate.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by yameng on 2014/4/8.
 */
public class A_TeacherCRUD {
    public static void create() {
        //维护双向关系
        Teacher teacherA = new Teacher("A");
        Teacher teacherB = new Teacher("B");

        Student studentA = new Student("sA");
        Student studentB = new Student("sB");
        Student studentC = new Student("sC");
        Student studentD = new Student("sD");
        teacherA.getStudents().add(studentA);
        teacherA.getStudents().add(studentB);
        teacherB.getStudents().add(studentC);
        teacherB.getStudents().add(studentD);

        studentA.getTeachers().add(teacherA);
        studentA.getTeachers().add(teacherB);
        studentB.getTeachers().add(teacherA);
        studentC.getTeachers().add(teacherA);
        studentD.getTeachers().add(teacherB);
        studentA.getTeachers().add(teacherA);

        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(teacherA);
            session.save(teacherB);
            session.save(studentC);
            session.save(studentD);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }

    public static void main(String[] args) {
        A_TeacherCRUD.create();
    }
}
