package com.obs.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Kursun benzersiz ID'si

    private String courseName;  // Kursun adı

    private int duration;  // Kursun süresi (örneğin, saat cinsinden)

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;  // Kursun atanmış öğretmeni

    @ManyToMany
    @JoinTable(
            name = "course_student",  // Öğrenci ve kurs arasındaki ilişki tablosu
            joinColumns = @JoinColumn(name = "course_id"),  // Kurs ID'si
            inverseJoinColumns = @JoinColumn(name = "student_id"))  // Öğrenci ID'si
    private List<Student> students;  // Kursa kayıtlı öğrenciler

    // Getter ve Setter metodları

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // Kursa bir öğrenci ekler
    public void addStudent(Student student) {
        this.students.add(student);
    }
}
