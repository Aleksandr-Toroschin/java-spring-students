package ru.geekbrains.spring.one.DAO;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class StudentDAO {
    private SessionFactory factory;

    public StudentDAO(SessionFactory factory) {
        this.factory = factory;
    }
}
