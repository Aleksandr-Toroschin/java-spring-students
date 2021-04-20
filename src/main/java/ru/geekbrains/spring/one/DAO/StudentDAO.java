package ru.geekbrains.spring.one.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.one.model.Student;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentDAO {
    private SessionFactory factory;

    @Autowired
    public StudentDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @PostConstruct
    public void prepareData() {
        Session session = null;
        try {
            String sql = Files.lines(Paths.get("full.sql")).collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Student findById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            factory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();
            return student;
        }
    }

    public List<Student> findAll() {
        try (Session session = factory.getCurrentSession()) {
            factory.getCurrentSession();
            session.beginTransaction();

            List<Student> students = session.createQuery("from Student").getResultList();

            session.getTransaction().commit();
            return students;
        }
    }

    public void save(Student student) {
        try (Session session = factory.getCurrentSession()) {
            factory.getCurrentSession();
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }
    }

    public void delete(Long id) {
        try (Session session = factory.getCurrentSession()) {
            factory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.delete(student);
            session.getTransaction().commit();
        }
    }

}
