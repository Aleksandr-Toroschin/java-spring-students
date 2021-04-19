package ru.geekbrains.spring.one.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.one.DAO.StudentDAO;
import ru.geekbrains.spring.one.model.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class StudentRepository {
    private List<Student> students;
    private StudentDAO studentDAO;

    @Autowired
    public StudentRepository(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @PostConstruct
    public void init() {
        // получить factory
    }

    public List<Student> findAll() {
        return students;
    }

    public void save(Student student) {
        students.add(student);
    }

    public Optional<Student> findOneById(Long id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    public void deleteById(Long id) {
        students.removeIf(s -> s.getId().equals(id));
    }
}
