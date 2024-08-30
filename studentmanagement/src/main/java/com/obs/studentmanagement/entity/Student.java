package com.obs.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // ID otomatik olarak artırılır
    @Column(name="ID")
    private long studentId;  // Öğrencinin benzersiz ID'si

    @Column(name="name")
    private String studentName;  // Öğrencinin adı

    @Column(name="mail")
    private String mail;  // Öğrencinin e-posta adresi

    @Column(name="phone")
    private String phone;  // Öğrencinin telefon numarası

    // Getter ve Setter metodları

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @ManyToMany(mappedBy = "students")  // Bu öğrencinin bağlı olduğu kurslar
    private List<Course> courses;  // Öğrencinin aldığı kurslar

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}