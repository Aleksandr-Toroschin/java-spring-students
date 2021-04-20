package ru.geekbrains.spring.one;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("ru.geekbrains.spring.one")
public class AppConfig {
    @Bean
    public SessionFactory factory() {
        try {
            return new org.hibernate.cfg.Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException("Невозможно подключиться к БД");
        }
    }
}
