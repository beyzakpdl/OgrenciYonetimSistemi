package com.obs.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // ID otomatik olarak artırılır
    @Column(name="ID")
    private long TeacherId;  // Öğretmenin benzersiz ID'si

    @Column(name="name")
    private String teacherName;  // Öğretmenin adı

    @Column(name="mail")
    private String mail;  // Öğretmenin e-posta adresi

    @Column(name="phone")
    private String phone;  // Öğretmenin telefon numarası

    // Getter ve Setter metodları

    public long getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(long teacherId) {
        TeacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    @OneToMany(mappedBy = "teacher")  // Öğretmenin verdiği kurslar
    private List<Course> courses;  // Öğretmenin verdiği kurslar

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}