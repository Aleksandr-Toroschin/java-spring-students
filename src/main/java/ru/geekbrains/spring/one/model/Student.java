package ru.geekbrains.spring.one.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="score")
    private int score;

    public void incrementScore() {
        if (score<100) {
            score++;
        }
    }

    public void decrementScore() {
        if (score>0) {
            score--;
        }
    }
}
