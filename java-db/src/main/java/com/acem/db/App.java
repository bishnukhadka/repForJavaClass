package com.acem.db;

import com.acem.db.dao.StudentDao;
import com.acem.db.dao.impl.StudentDaoFileImpl;
import com.acem.db.model.Student;

import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentDao studentDaoFile = new StudentDaoFileImpl();
        System.out.println("beforw");
        System.out.println(studentDaoFile.getAll());

        Student student = new Student(1l,"ramlal", "ramlal@gmail.com", "8688768768");
        studentDaoFile.save(student);

        System.out.println("after");
        System.out.println(studentDaoFile.getAll());




    }
}
