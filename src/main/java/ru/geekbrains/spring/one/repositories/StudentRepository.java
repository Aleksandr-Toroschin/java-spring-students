package ru.geekbrains.spring.one.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.one.DAO.StudentDAO;
import ru.geekbrains.spring.one.model.Student;

import java.util.List;
import java.util.Optional;

@Component
public class StudentRepository {
    private StudentDAO studentDAO;

    @Autowired
    public StudentRepository(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    public void save(Student student) {
        studentDAO.save(student);
    }

    public Optional<Student> findOneById(Long id) {
        return Optional.ofNullable(studentDAO.findById(id));
    }

    public void deleteById(Long id) {
        studentDAO.delete(id);
    }
}
